 define ["App", "ember"], (App, Ember) ->
  App.StaffController = Ember.Controller.extend
    name: "StaffController"
    
    console.log("StaffController created")
    
#    actions: 
#    	 staff: () ->
#    	 	 @transitionToRoute('staff')
