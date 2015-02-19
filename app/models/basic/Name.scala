package models.basic

import com.github.aselab.activerecord.{ActiveRecord, ActiveRecordCompanion, Timestamps, Datestamps}
import play.api.libs.json.Json
import models.Person

case class Name(first: String, middle: Option[String], last: String) extends ActiveRecord with Timestamps with Datestamps{
  lazy val person = hasOne[Person]
//  val personId: Option[Long] = None
}

object Name extends ActiveRecordCompanion[Name] {
    implicit val nameFormat = Json.format[Name]
}