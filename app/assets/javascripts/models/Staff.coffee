define ["App", "ember", "ember-data"], (App, Ember, DS) ->
  App.Staff = DS.Model.extend
  return

  App.Staff.reopenClass (
    FIXTURES: [
      {
       id: 1
      },
      {
       id: 2
      }
    ]
  )
  return