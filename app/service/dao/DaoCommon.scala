package service.dao

import scala.collection.mutable.HashMap
import java.util.UUID
import play.api.libs.iteratee.{Enumerator, Concurrent}
import play.api.libs.json.JsValue
import play.api.libs.iteratee.Concurrent.Channel
import play.api.Logger
import akka.actor.ActorSystem
import scala.concurrent.Future
import actors.message.dao._

class DaoCommon(val system: ActorSystem) {
  import system.dispatcher
  var channelMap = new HashMap[UUID,(Enumerator[JsValue], Channel[JsValue])]
  
  def subscribe(uuid: UUID): Future[SubscriptionResponse] = Future{
    val con = Concurrent.broadcast[JsValue]
    channelMap += (uuid -> con)
    Logger.debug(s"subscribed uuid $uuid to new channel")
    SubscribeConfirm(con._1)
  }
  
  def unsubscribe(uuid: UUID): Future[SubscriptionResponse] = Future{
    channelMap -= (uuid)
    Logger.debug(s"UNsubscribed uuid $uuid from new channel")
    UnSubscriveConfirm()
  }
  
  def unicast(uuid: UUID, msg: JsValue) {
    Future{
      Logger.debug(s"unicast from $this to uuid $uuid: pushing message $msg")
      channelMap(uuid)._2.push(msg)
    }
  }
  
    def broadcast(msg: JsValue) {
    Future {
      Logger.debug(s"broadcast from $this: pushing message $msg")
      channelMap.foreach { 
        _._2._2.push(msg)
      }
    }
  }
}