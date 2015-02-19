package models.basic

import com.github.aselab.activerecord.{ActiveRecord, ActiveRecordCompanion, Timestamps, Datestamps}
import models.Patient
import play.api.libs.json.Json
import com.github.aselab.activerecord.annotations.Unique

case class Email(@Unique email: String, emailType: String) extends ActiveRecord with Timestamps with Datestamps {
  lazy val emailGroup = belongsTo[EmailGroup]
}

object Email extends ActiveRecordCompanion[Email] {
    implicit val emailFormat = Json.format[Email]
}

case class EmailGroup() extends ActiveRecord with Timestamps with Datestamps {
  lazy val mainEmail = hasOne[Email]
  lazy val emails = hasMany[Email]
  
  val personId: Option[Long] = None
  lazy val person = belongsTo[Patient]
} 

object EmailGroup extends ActiveRecordCompanion[EmailGroup] {
//    implicit val emailGroupFormat = Json.format[EmailGroup]
}