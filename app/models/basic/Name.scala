package models.basic

import com.github.aselab.activerecord.{ActiveRecord, ActiveRecordCompanion}
import play.api.libs.json.Json

case class Name(first: String, middle: Option[String], last: String, val patientId: Option[Long] = None, override val id: Long = 0) extends ActiveRecord

object Name extends ActiveRecordCompanion[Name] {
    implicit val nameFormat = Json.format[Name]
}