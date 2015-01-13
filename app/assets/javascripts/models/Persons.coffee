define ["App", "ember", "ember-data"], (App, Ember, DS) ->
  App.Persons = DS.Model.extend
  return

  App.Persons.reopenClass (
    FIXTURES: [
      {
       id: 1
      }
    ]
  )
  return