package actors.notifications

import org.specs2.mutable.Specification
import org.specs2.time.NoTimeConversions
import actors.ActorTestkitSpecs2Base
import scala.concurrent.duration._
import akka.actor.Props
import actors.message.dao.NotificationMessage
import actors.message.dao.Subscribe
import java.util.UUID

class NotifyActorSpec extends Specification with NoTimeConversions {
  sequential // forces all tests to be run sequentially
  "NotifyActor" should {
    "" in new ActorTestkitSpecs2Base {
      within(1 second) {
        system.actorOf(Props[NotifyActor], "NotifyActor") ! NotificationMessage("patients", Subscribe(UUID.randomUUID()))
      }
    }
  }
}