package actors.notifications.messages

import models.Person

case class AddPerson(person: Person)
case class UpdatePerson(person: Person)
case class RemovePerson(person: Person)