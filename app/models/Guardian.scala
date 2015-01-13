package models

import models.basic.{Name,AddressGroup, PhoneGroup, EmailGroup}
import com.github.aselab.activerecord._
import org.joda.time.DateTime
import play.api.libs.json.Json

case class Guardian(
  override val dateOfBirth: Long,
  override val id: Long = 0) 
extends ActiveRecord with Timestamps with Datestamps with Person{
  lazy val guardees = hasMany[Patient]
}

object Guardian extends ActiveRecordCompanion[Guardian] {
  implicit val personFormat = Json.format[Guardian]
}