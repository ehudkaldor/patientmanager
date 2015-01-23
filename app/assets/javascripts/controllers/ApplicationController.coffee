define ["App", "ember"], (App, Ember) ->
  App.ApplicationController = Ember.Controller.extend
    appName: "PatientManager"
    isEditable: false
            
    actions:
      managehost: (id) ->
        console.log("managehost id=" + id)
      logout: () ->
        alert("logout")
      home: () ->
      	 @transitionToRoute('index')
        
    console.log("ApplicationController created")
