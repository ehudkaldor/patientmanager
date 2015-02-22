package actors.notifications

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import actors.notifications.messages.AddPerson
import scala.collection.mutable.HashMap
import java.util.UUID
import play.api.libs.iteratee.Enumerator
import play.api.libs.iteratee.Concurrent.Channel
import play.api.libs.json.JsValue
import actors.message.dao._
import play.api.Logger
import play.api.libs.iteratee.Concurrent

class NotifyActor extends Actor with ActorLogging{
  val actorFactory = context  
  val channelMap = new HashMap[String, ActorRef].empty
  
  channelMap += ("patients" -> actorFactory.actorOf(Props[NotificationBaseActor], "patients"))  
  
  def receive = {
    case NotificationMessage(channelName, msg) => {
      log.debug(s"received message for channel $channelName, of type ${msg.getClass.getName}")
      channelMap.get(channelName) match{
        case Some(chanActor) => chanActor forward msg
        case None => log.warning(s"got message for channel $channelName, which is not found in channel list. Message type is ${msg.getClass.getName} and its content is ${msg.toString()}")
      }
    }
  }
}