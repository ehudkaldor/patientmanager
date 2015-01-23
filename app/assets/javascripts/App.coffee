define ["ember", "ember-data"], (Ember, DS) ->
  console.log("creating application")
  window.App = Ember.Application.create()
  App.ApplicationAdapter = DS.FixtureAdapter
#  App.Models = {}
#  App.Views = {}
  console.log("application created")
#  console.log(App)
  App
  
#  infra: () ->
#  	 App.Layout = Ember.Object.extend
#  	   name: null
#  	   template: null
#  	 
#  	 App.layouts = []
#  	 
#  	 App.layouts.pushObject
#  	   App.Layout.create
#  	     name: "block"
