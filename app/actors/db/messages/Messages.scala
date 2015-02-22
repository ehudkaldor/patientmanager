package actors.db.messages

import models.{Person, Patient, Guardian}

case class CreatePerson(person: Person)
case class DactivatePerson(person: Person)
case class DeletePerson(person: Person)

case class CreatePatient(patient: Patient)
case class DeactivatePatient(patient: Patient)
case class DeletePatient(patient: Patient)

case class CreateGuardian(guardian: Guardian)
case class DeactivateGuardian(guardian: Guardian)
case class DeleteGuardian(guardian: Guardian)
