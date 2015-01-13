package models.basic

import com.github.aselab.activerecord.{ActiveRecord, ActiveRecordCompanion}
import models.Patient
import play.api.libs.json.Json
import com.github.aselab.activerecord.annotations.Unique

case class Email(@Unique email: String, emailType: String, val emailGroupId: Option[Long] = None, override val id: Long = 0) extends ActiveRecord {
//  val emailGroupId: Option[Long] = None
  lazy val emailGroup = belongsTo[EmailGroup]
}

object Email extends ActiveRecordCompanion[Email] {
    implicit val emailFormat = Json.format[Email]
}

case class EmailGroup(val personId: Option[Long] = None,override val id: Long = 0) extends ActiveRecord {
  lazy val mainEmail = hasOne[Email]
  lazy val emails = hasMany[Email]
  
//  val personId: Option[Long] = None
  lazy val person = belongsTo[Patient]
} 

object EmailGroup extends ActiveRecordCompanion[EmailGroup] {
    implicit val emailGroupFormat = Json.format[EmailGroup]
}