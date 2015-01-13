package service.dao

import models.Patient
import models.basic._
import org.joda.time.DateTime
import play.api.Logger
import play.api.libs.concurrent.Akka
import play.api.Play.current
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsString
import play.api.libs.json.Json
import scala.concurrent.Future
import scala.concurrent.Promise
import akka.actor.Status.Failure
//import scala.actors.Future

object PatientDao extends DaoCommon(Akka.system) {
  import system.dispatcher

  def create(
      firstName: String, 
      middleName: Option[String], 
      lastName: String, 
      dateOfBirth: DateTime, 
      addr1: String,
      addr2: Option[String],
      addr3: Option[String],
      city: String,
      state: String,
      zip: String,
      country: String,
      primaryEmail: String,
      primaryEmailType: String,
      primaryPhone: String,
      primaryPhoneType: String,
      senderUuid: UUID
    ): Future[Patient] = Future {
    val name = Name(firstName, middleName, lastName).create
    val address = Address(addr1, addr2, addr3, city, state, zip, country).create
    val email = Email(primaryEmail, primaryEmailType).create
    val phone = Phone(primaryPhone, primaryPhoneType).create
    val patient = Patient(dateOfBirth.getMillis)
    patient.name := name
    patient.addressGroup := {
      val ag = AddressGroup().create
      ag.addresses << address
      ag.mainAddress := address
      ag
    }
    patient.emailGroup := {
      val eg = EmailGroup().create
      eg.emails << email
      eg.mainEmail := email
      eg
    }
    patient.phoneGroup := {
      val pg = PhoneGroup().create
      pg.phones << phone
      pg.mainPhone := phone
      pg
    }
    Logger.debug(s"created Person $patient")
    broadcast(
      JsObject(      
        Seq(
          "channel" -> JsString("persons"),
          "type" -> JsString("add"),
          "person" -> Json.toJson(patient)
        )
      )
    )
    patient
  }
  
  def addEmail(patient: Patient, email: String, emailType: String): Future[Patient] = {
      import com.github.aselab.activerecord.dsl._
      patient.emailGroup.emails.filter(_.email.equalsIgnoreCase(email)).size > 0 match {
        case false => {
          patient.emailGroup.emails << Email(email, emailType).create
          Future{patient}
        }
        case true => {
          Future.failed(new Exception())
        }
      }
//      patient
  }
}