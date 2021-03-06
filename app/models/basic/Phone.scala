package models.basic

import com.github.aselab.activerecord.{ActiveRecord, ActiveRecordCompanion, Timestamps, Datestamps}
import models.Patient
import play.api.libs.json.Json

case class Phone(phone: String, phoneType: String) extends ActiveRecord with Timestamps with Datestamps {
  val phoneGroupId: Option[Long] = None
  lazy val phoneGroup = belongsTo[PhoneGroup]

}

object Phone extends ActiveRecordCompanion[Phone] {
    implicit val phoneFormat = Json.format[Phone]
}

case class PhoneGroup() extends ActiveRecord with Timestamps with Datestamps {
  lazy val mainPhone= hasOne[Phone]
  lazy val phones = hasMany[Phone]
  
  lazy val person = belongsTo[Patient]
  val personId: Option[Long] = None
}

object PhoneGroup extends ActiveRecordCompanion[PhoneGroup] {
//    implicit val phoneGroupFormat = Json.format[PhoneGroup]
}