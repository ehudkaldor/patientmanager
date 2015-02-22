package actors.message.dao

import play.api.libs.iteratee.Enumerator
import play.api.libs.json.JsValue
import java.util.UUID

trait NotificationTrait

case class NotificationMessage(channelName: String, innerMessage: NotificationTrait)

trait SubscriptionResponse extends NotificationTrait
case class SubscribeConfirm(enumerator: Enumerator[JsValue]) extends SubscriptionResponse
case class UnSubscriveConfirm() extends SubscriptionResponse
case class SubscribeFailed() extends SubscriptionResponse

trait SubscriptionRequest extends NotificationTrait
case class Subscribe(uuid: UUID) extends SubscriptionRequest
case class Unsubscribe(uuid: UUID) extends SubscriptionRequest

trait Cast extends NotificationTrait
case class Unicast(uuid: UUID, msg: JsValue)
case class Broadcast(msg: JsValue)