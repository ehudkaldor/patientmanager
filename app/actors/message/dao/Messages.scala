package actors.message.dao

import play.api.libs.iteratee.Enumerator
import play.api.libs.json.JsValue

class SubscriptionResponse
case class SubscribeConfirm(enumerator: Enumerator[JsValue]) extends SubscriptionResponse
case class UnSubscriveConfirm() extends SubscriptionResponse
case class SubscribeFailed() extends SubscriptionResponse