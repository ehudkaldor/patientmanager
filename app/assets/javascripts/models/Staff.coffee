define ["App", "ember", "ember-data", "models/Person"], (App, Ember, DS) ->
  App.StaffMixin = Ember.Mixin.create
    me: DS.attr()
	 
  App.Staff = App.Person.extend(App.StaffMixin)
#    return

  App.Staff.reopenClass (
    FIXTURES: [
      {
       id: 1,
       name: 10,
       gender: "male",
       me: "staff a"
      },
      {
       id: 2,
       name: 20,
       gender: "female",
       me: "staff b"
      }
    ]
  )
  return