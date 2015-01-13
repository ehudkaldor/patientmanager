define ["App", "ember", "ember-data"], (App, Ember, DS) ->
  App.PersonShowController = Ember.Controller.extend
    actions:
      managehost: (id) ->
        console.log("managehost id=" + id)
      personShow: () ->
        alert("weee")
        
    console.log("PersonShowController created")