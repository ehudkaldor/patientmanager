package models.basic

import com.github.aselab.activerecord.ActiveRecordSpecification
import com.github.aselab.activerecord.dsl._

object AddressSpec extends ActiveRecordSpecification {
  
  "Address model" should {
    "Create a transient Address" in {
      val addr1line = Address("street1", None, None, "city", "state", "zip", "country", None)
      val addr2line = Address("street1", Option("street2"), None, "city", "state", "zip", "country")
      val addr3line = Address("street1", Option("street2"), Option("street3"), "city", "state", "zip", "country")
      
      addr1line.addr1 must equalTo("street1")
      addr1line.addr2 must equalTo(None)
      addr1line.addr3 must equalTo(None)

      addr2line.addr1 must equalTo("street1")
      addr2line.addr2 must equalTo(Option("street2"))
      addr2line.addr3 must equalTo(None)

      addr3line.addr1 must equalTo("street1")
      addr3line.addr2 must equalTo(Some("street2"))
      addr3line.addr3 must equalTo(Some("street3"))
    }
    
    "Create an Address and save it to db" in {
      val addr1line = Address("street1", None, None, "city", "state", "zip", "country").create
      Address.find(addr1line.id) must not be(None)
      Address.find(addr1line.id).get.addr1  must equalTo("street1")      
    }
    
    "Create an Address and assign it to an AddressGroup" in {
      val addrGroup = AddressGroup().create
      addrGroup must not be(None)
      val addr1line = Address("street1", None, None, "city", "state", "zip", "country").create
      addr1line must not be(None)
      
      addrGroup.addresses << addr1line

      addr1line.addressGroupId must not be(None)
      AddressGroup.find(addr1line.addressGroupId.get) must not be(None)
      AddressGroup.find(addr1line.addressGroupId.get).get must equalTo(addrGroup)
      
      addrGroup.addresses.toList.head must equalTo(addr1line)
      addr1line.addressGroup.get must equalTo(addrGroup)
    }
    
    "Create an Address, assign to an AddressGroup and change to a different AddressGroup" in {
      val addrGroup1 = AddressGroup().create
      addrGroup1 must not be(None)
      val addrGroup2 = AddressGroup().create
      addrGroup2 must not be(None)
      val addr1line = Address("street1", None, None, "city", "state", "zip", "country").create
      addr1line must not be(None)
      
      addrGroup1.addresses << addr1line

      addr1line.addressGroupId must not be(None)
      AddressGroup.find(addr1line.addressGroupId.get) must not be(None)
      AddressGroup.find(addr1line.addressGroupId.get).get must equalTo(addrGroup1)
      Address.find(addr1line.id).get.addressGroupId.get must equalTo(addrGroup1.id)
      

//      val removed = addrGroup1.addresses.remove(addr1line)
//      removed must not be(None)
//
//      Address.find(removed.get.id).get.addressGroupId must be(None)
      
      addrGroup2.addresses << addr1line//      val removed = addrGroup1.addresses.remove(addr1line)
//      removed must not be(None)
//
//      Address.find(removed.get.id).get.addressGroupId must be(None)

      AddressGroup.find(addr1line.addressGroupId.get) must not be(None)
      AddressGroup.find(addr1line.addressGroupId.get).get must not equalTo(addrGroup1)
      AddressGroup.find(addr1line.addressGroupId.get).get must equalTo(addrGroup2)
      Address.find(addr1line.id).get.addressGroupId.get must equalTo(addrGroup2.id)
      
      
    }
    
//    "Create an address and set it as the primary address" in {
//      
//    }
  }
}