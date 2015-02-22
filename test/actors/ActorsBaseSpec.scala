package actors

import akka.testkit.{TestKit, ImplicitSender}
import akka.actor.{ActorSystem, Actor, Props}
import scala.concurrent.duration._
import org.specs2.specification.After
import org.specs2.mutable.Specification
import org.specs2.time.NoTimeConversions


/* A tiny class that can be used as a Specs2 'context'. */
abstract class ActorTestkitSpecs2Base extends TestKit(ActorSystem()) 
                                           with After 
                                           with ImplicitSender {
  // make sure we shut down the actor system after all tests have run
  def after = system.shutdown()
}

/* Both Akka and Specs2 add implicit conversions for adding time-related
   methods to Int. Mix in the Specs2 NoTimeConversions trait to avoid a clash. */
class ExampleSpec extends Specification with NoTimeConversions {
  sequential // forces all tests to be run sequentially

  "A TestKit" should {
    /* for every case where you would normally use "in", use 
       "in new AkkaTestkitSpecs2Support" to create a new 'context'. */
    "work properly with Specs2 unit tests" in new ActorTestkitSpecs2Base {
        within(1 second) {
          val msg = "me"
          system.actorOf(Props(new Actor {
            def receive = { case x ⇒ sender ! x }
          })) ! msg
          expectMsgType[String] must be equalTo msg
        }
      }
  }
}