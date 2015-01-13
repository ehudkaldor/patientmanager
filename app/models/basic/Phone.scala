package models.basic

import com.github.aselab.activerecord.{ActiveRecord, ActiveRecordCompanion}
import models.Patient
import play.api.libs.json.Json

case class Phone(phone: String, phoneType: String, override val id: Long = 0) extends ActiveRecord {
  val phoneGroupId: Option[Long] = None
  lazy val phoneGroup = belongsTo[PhoneGroup]

}

object Phone extends ActiveRecordCompanion[Phone] {
    implicit val phoneFormat = Json.format[Phone]
}

case class PhoneGroup(val personId: Option[Long] = None, override val id: Long = 0) extends ActiveRecord {
  lazy val mainPhone= hasOne[Phone]
  lazy val phones = hasMany[Phone]
  
//  val personId: Option[Long] = None
  lazy val person = belongsTo[Patient]
}

object PhoneGroup extends ActiveRecordCompanion[PhoneGroup] {
    implicit val phoneGroupFormat = Json.format[PhoneGroup]
}