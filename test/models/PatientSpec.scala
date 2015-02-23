package models

import com.github.aselab.activerecord.ActiveRecordSpecification
import com.github.aselab.activerecord.dsl._
import org.joda.time.DateTime
import models.basic.{AddressGroup, Address, Name}

object PatientSpec extends ActiveRecordSpecification {
  "Create Person" should {
    "Create transient person with no values" in {
      val dob = DateTime.now
      val person = Patient(dob.getMillis)
      person must not be null
      person.dateOfBirth must equalTo(dob.getMillis)
    }
  }
  
  "Create and persist Patient" should {
    "Save a Patient with no values" in {
      val dob = DateTime.now
      val patient = Patient(dob.getMillis).create
      patient must not be null
      patient.dateOfBirth must equalTo(dob.getMillis)
      
      Patient.find(patient.id) must not be(None)
      Patient.find(patient.id).get must equalTo(patient)
    }
    
    "Create and persist Patient with Name and Address" in {
      val dob = DateTime.now
      val patient = Patient(dob.getMillis).create
      val name = Name("first", None, "last").create
      val address = Address("street1", None, None, "city", "state", "zip", "country").create
      val addressGroup = AddressGroup().create
      val id = patient.id
      
//      addressGroup.mainAddress := address
//      addressGroup.addresses << address
      
      patient.name := name

//      patient.addressGroup := addressGroup      
//      addressGroup.mainAddress := address
      
      Patient.find(id) must not be(None)
      
      println(Patient.find(id).get.name.toOption)

      Patient.find(id).get.name must not be(None)
      Patient.find(id).get.name.toOption.get must equalTo(name)

//      Patient.find(patient.id).get.addressGroup must not be(None)
//      Patient.find(patient.id).get.addressGroup.toOption.get.addresses.toList must not be(None)
//      Patient.find(patient.id).get.addressGroup.toOption.get.addresses.toList.head must equalTo(address)
//      Patient.find(patient.id).get.addressGroup.toOption.get.mainAddress.toOption must not be(None)
//      Patient.find(patient.id).get.addressGroup.toOption.get.mainAddress.toOption.get must equalTo(address)
    }
  }  
}