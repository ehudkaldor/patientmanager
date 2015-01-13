package models

import com.github.aselab.activerecord._
import com.github.aselab.activerecord.dsl._
import models.basic._ 

object Tables extends ActiveRecordTables{
  val names = table[Name]
  val addresses = table[Address]
  val addressGroups = table[AddressGroup]
  val emails = table[models.basic.Email]
  val emailGroups = table[EmailGroup]
  val phones = table[Phone]
  val phoneGroups = table[PhoneGroup]  
  val patients = table[Patient]
  val guardians = table[Guardian]
  
  on(emails)(t => declare(
    t.email is(unique)
  ))

  on(phones)(t => declare(
    t.phone is(unique)
  ))

}