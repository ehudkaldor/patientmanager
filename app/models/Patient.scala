package models

import models.basic.{Name,AddressGroup, PhoneGroup, EmailGroup}
import com.github.aselab.activerecord._
import org.joda.time.DateTime
import play.api.libs.json.Json

case class Patient(
  override val dateOfBirth: Long,
  val userId: Option[Long] = None, 
  override val id: Long = 0) 
extends ActiveRecord with Timestamps with Datestamps with Person {
  lazy val guardians = hasMany[Guardian]
}

object Patient extends ActiveRecordCompanion[Patient] {
  implicit val personFormat = Json.format[Patient]
}