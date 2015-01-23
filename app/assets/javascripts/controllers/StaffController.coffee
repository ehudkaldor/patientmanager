 define ["App", "ember", "text!../templates/staff_cards.handlebars", "text!../templates/staff_list.handlebars",], (App, Ember, cardstpl, listtpl) ->
  App.StaffController = Ember.Controller.extend
    name: "StaffController"
    
    templates = Ember.Map.create()
    templates.set("block", Ember.Handlebars.compile(cardstpl))
    templates.set("list", Ember.Handlebars.compile(listtpl))
    
    console.log("StaffController created")
    
#    actions: 
#    	 staff: () ->
#    	 	 @transitionToRoute('staff')
