define ["App", "ember", "ember-data"], (App, Ember, DS) ->
  App.PersonsController = Ember.ArrayController.create
    me: "me"
    actions:
      managehost: (id) ->
        console.log("managehost id=" + id)
      personShow: () ->
      	 alert("weee")
        
    console.log("PersonsController created")