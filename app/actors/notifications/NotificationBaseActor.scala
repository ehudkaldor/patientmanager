package actors.notifications

import akka.actor.{Actor, ActorLogging}
import actors.notifications.messages.AddPerson
import scala.collection.mutable.HashMap
import java.util.UUID
import play.api.libs.iteratee.Enumerator
import play.api.libs.iteratee.Concurrent.Channel
import play.api.libs.json.JsValue
import actors.message.dao._
import play.api.Logger
import play.api.libs.iteratee.Concurrent

class NotificationBaseActor extends Actor with ActorLogging{
  
  var channelMap = new HashMap[UUID,(Enumerator[JsValue], Channel[JsValue])]
  
  def receive = {
    case Subscribe(uuid) => sender ! subscribe(uuid)
    case Unsubscribe(uuid) => sender ! unsubscribe(uuid)
    case Unicast(uuid, msg) => sender ! unicast(uuid, msg)
    case Broadcast(msg) => sender ! broadcast(msg)
  }

  
  def subscribe(uuid: UUID) = {
    val con = Concurrent.broadcast[JsValue]
    channelMap += (uuid -> con)
    log.debug(s"subscribed uuid $uuid to new channel")
    SubscribeConfirm(con._1)
  }
  
  def unsubscribe(uuid: UUID) = {
    channelMap -= (uuid)
    log.debug(s"UNsubscribed uuid $uuid from new channel")
    UnSubscriveConfirm()
  }
  
  def unicast(uuid: UUID, msg: JsValue) {
    log.debug(s"unicast from $this to uuid $uuid: pushing message $msg")
    channelMap(uuid)._2.push(msg)
  }
  
  def broadcast(msg: JsValue) {
    log.debug(s"broadcast from $this: pushing message $msg")
    channelMap.foreach { 
       _._2._2.push(msg)
    }
  }
}