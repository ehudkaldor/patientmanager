package models

import com.github.aselab.activerecord.ActiveRecordSpecification
//import com.github.aselab.activerecord.dsl._
import org.joda.time.DateTime
import models.basic.AddressGroup
import models.basic.Address
import models.basic.Name
import models.basic.AddressGroup

object PersonSpec extends ActiveRecordSpecification {
  "Create Person" should {
    "Create transient person with no values" in {
      val dob = DateTime.now
      val person = Patient(dob.getMillis)
      person must not be null
      person.dateOfBirth must equalTo(dob.getMillis)
    }
  }
  
  "Create and persist Person" should {
    "Save a Person with no values" in {
      val dob = DateTime.now
      val person = Patient(dob.getMillis).create
      person must not be null
      person.dateOfBirth must equalTo(dob.getMillis)
      
      Patient.find(person.id) must not be(None)
      Patient.find(person.id).get must equalTo(person)
    }
    
    "Create and persist Person with Name and Address" in {
      val dob = DateTime.now
      val patient = Patient(dob.getMillis).create
      val name = Name("first", None, "last").create
      val address = Address("street1", None, None, "city", "state", "zip", "country").create
      val addressGroup = AddressGroup().create
      
      addressGroup.mainAddress := address
      
      
//      patient.name := name
//      patient.addressGroup := addressGroup
      
      Patient.find(patient.id) must not be(None)
      Patient.find(patient.id).get.name.build must not be(None)
//      Patient.find(patient.id).get.name.toOption.get must equalTo(name)
//
//      Patient.find(patient.id).get.addressGroup.toOption must not be(None)
//      Patient.find(patient.id).get.addressGroup.toOption.get.mainAddress.toOption must not be(None)
//      Patient.find(patient.id).get.addressGroup.toOption.get.mainAddress.toOption.get must equalTo(address)
    }
  }  
}