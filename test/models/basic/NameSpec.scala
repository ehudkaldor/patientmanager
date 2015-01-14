package models.basic

import com.github.aselab.activerecord.ActiveRecordSpecification

object NameSpec extends ActiveRecordSpecification{
  
  "Name model" should {
    "Create a transient Name" in {
      val nameNoMiddle = Name("ehud", None, "kaldor")
      nameNoMiddle.first must equalTo("ehud")
      nameNoMiddle.middle  must equalTo(None)
      
      val nameWithMiddle = Name("ehud", Option("jay"), "kaldor")
      nameWithMiddle.middle  must equalTo(Option("jay"))
    }
    
    "Create a Name and save it to db" in {
      val name = Name("ehud", None, "kaldor").create
      Name.find(name.id) must not be(None)
      Name.find(name.id).get.first must equalTo("ehud")      
    }
    
    "Save a Name to db and find by first name" in {
      Name("ehud", None, "kaldor").save
      Name.findBy("first", "ehud") must not be(None)
      Name.findBy("first", "ehud").get.last must equalTo("kaldor")      
    }
    
    "Save a Name to db, update and make sure updates persisted" in {
      Name("ehud", None, "kaldor").save
      Name.findBy("first", "ehud") must not be(None)
      Name.findBy("first", "ehud").get.last must equalTo("kaldor") 
      Name.findBy("first", "ehud").get.copy(last = "dank").update
      Name.findBy("first", "ehud").get.last must equalTo("dank") 
    }
  }

}