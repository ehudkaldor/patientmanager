package models.basic

import com.github.aselab.activerecord.ActiveRecordSpecification
import org.squeryl.SquerylSQLException

object EmailSpec extends ActiveRecordSpecification{
  
  "Email model" should {
    "Create a transient Email" in {
      val email = Email("ehud@mail.com", "personal")
      email.email must equalTo("ehud@mail.com")
      email.emailType  must equalTo("personal")
    }

    "Create a Email and save it to db" in {
      val email = Email("ehud@mail.com", "personal").create
      Email.find(email.id) must not be(None)
      Email.find(email.id).get.email must equalTo("ehud@mail.com")      
    }
    
    "Should NOT be able to insert same email address twice" in {
//      val email = Email("ehud@mail.com", "personal").create
//      email.email must equalTo("ehud@mail.com")
//      email.emailType  must equalTo("personal")
      
      Email("ehud@mail.com", "work").create must throwA[SquerylSQLException] 
//      Email.findBy("emailType", "work").get.email must equalTo("ehud@mail.com")
//      Email.findBy("emailType", "personal").get.email must equalTo("ehud@mail.com")
    }
        
    "Save a Email to db and find by email address" in {
//      val email = Email("ehud@mail.com", "personal").save
      Email.findBy("email", "ehud@mail.com") must not be(None)
      Email.findBy("email", "ehud@mail.com").get.emailType must equalTo("personal")      
    }
    
    "Save an Email to db, update and make sure updates persisted" in {
//      val email = Email("ehud@mail.com", "personal").save
      Email.findBy("email", "ehud@mail.com") must not be(None)
      Email.findBy("email", "ehud@mail.com").get.emailType must equalTo("personal") 
      Email.findBy("email", "ehud@mail.com").get.copy(emailType = "work").update
      Email.findBy("email", "ehud@mail.com").get.emailType must equalTo("work") 
    }
  }
}