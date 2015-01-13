define ["App", "ember"], (App, Ember) ->
  App.ApplicationController = Ember.Controller.extend
    appName: "SchoolMe"
    isEditable: false
            
    actions:
      managehost: (id) ->
        console.log("managehost id=" + id)
        
    console.log("ApplicationController created")
