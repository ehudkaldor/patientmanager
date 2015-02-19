package models.basic

import com.github.aselab.activerecord.{ActiveRecord, ActiveRecordCompanion, Timestamps, Datestamps}
import models.Patient
import play.api.libs.json.Json
import models.Person

case class Address (
  addr1: String, 
  addr2: Option[String], 
  addr3: Option[String], 
  city: String, 
  state: String, 
  zip: String, 
  country: String) extends ActiveRecord  with Timestamps with Datestamps{
  lazy val addressGroup = belongsTo[AddressGroup]
  val addressGroupId: Option[Long] = None  
}

object Address extends ActiveRecordCompanion[Address] {
  implicit val addressFormat = Json.format[Address]
}

case class AddressGroup() extends ActiveRecord  with Timestamps with Datestamps{
  lazy val mainAddress = hasOne[Address]
  lazy val addresses = hasMany[Address]
  lazy val person = belongsTo[Person]
  val personId: Option[Long] = None
}

object AddressGroup extends ActiveRecordCompanion[AddressGroup] {
//    implicit val addressGroupFormat = Json.format[AddressGroup]
}