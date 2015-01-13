package models.basic

import com.github.aselab.activerecord.{ActiveRecord, ActiveRecordCompanion}
import models.Patient
import play.api.libs.json.Json

case class Address (
  addr1: String, 
  addr2: Option[String], 
  addr3: Option[String], 
  city: String, 
  state: String, 
  zip: String, 
  country: String,
  val addressGroupId: Option[Long] = None,
  override val id: Long = 0) extends ActiveRecord {
//    val addressGroupId: Option[Long] = None
    lazy val addressGroup = belongsTo[AddressGroup]
}

object Address extends ActiveRecordCompanion[Address] {
    implicit val addressFormat = Json.format[Address]
}

case class AddressGroup(val personId: Option[Long] = None, override val id: Long = 0) extends ActiveRecord {
  lazy val mainAddress = hasOne[Address]
  lazy val addresses = hasMany[Address]
  
//  val personId: Option[Long] = None
  lazy val person = belongsTo[Patient]
}

object AddressGroup extends ActiveRecordCompanion[AddressGroup] {
    implicit val addressGroupFormat = Json.format[AddressGroup]
}