define ["ember", "ember-data"], (Ember, DS) ->
  console.log("creating application")
  window.App = Ember.Application.create()
  App.ApplicationAdapter = DS.FixtureAdapter
#  App.Models = {}
#  App.Views = {}
  console.log("application created")
#  console.log(App)
  App
