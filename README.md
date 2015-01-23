# PatientManager

First and foremost, PatientManager is an exercise in programming. Please jump down for the exercise description.

The PatientManager application is, pretty simply, a clinic management web app. Patients, guardians (for minor patients) and staff members should all be represented. 

For patients, staff members (doctors, therapists) maintain a case. A case should have a record of sessions and more, and also has the ability to schedule future meetings, and send reminders to the doctor, patient or guardian.
A guardian is needed for anyone underaged, and they will be the contact point for the patient. A patient can have more than one guardian (two parents, etc.).
Staff members holds data on the practitioners. It is for the clinic administration, but can also be the basis for the 'our staff' page in the clinic's public site.


Exercise: 

	backend: 
		Play Framework (TypeSafe Activator), Scala
		Database: TBD (relational, currently H2 in-memory database)
		Database connector: Scala ActiveRecord

	frontend:
		Ember.JS
			currently with require.js as AMD, attempting to fork to using Ember-CLI
		CSS: semantic.ui

