package models

import com.github.aselab.activerecord.{Timestamps, Datestamps, ActiveRecord}
import models.basic.{Name, AddressGroup, PhoneGroup, EmailGroup}

trait Person extends ActiveRecord with Timestamps with Datestamps {
  lazy val name = hasOne[Name]
  val dateOfBirth: Long
  lazy val addressGroup = hasOne[AddressGroup]
  lazy val phoneGroup = hasOne[PhoneGroup]
  lazy val emailGroup = hasOne[EmailGroup]
}

