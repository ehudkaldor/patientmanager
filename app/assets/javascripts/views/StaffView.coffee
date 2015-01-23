define [
	 "App", 
	 "ember", 
		"text!../templates/staff.handlebars", 
	 "text!../templates/staff_cards.handlebars", 
  "text!../templates/staff_list.handlebars", 
  "components/PersonCardComponent"
	 "semantic"]
, (App, Ember, tpl, cardstpl, listtpl, personCardComp) ->
  App.StaffView = Ember.View.extend
    
#    defaultTemplate: Ember.Handlebars.compile(tpl)    
    layout: Ember.Handlebars.compile(tpl)    
    templates = Ember.Map.create()
    templates.set("block", Ember.Handlebars.compile(cardstpl))
    templates.set("list", Ember.Handlebars.compile(listtpl))
    
#    App.PersonCardComponent = Ember.Handlebars.compile(personCardComp)

    template: templates.get("list")
        
    actions:
    	 toggleTemplate: (tmpl) ->
    	 	 console.log(tmpl)
    	 	 @set("template", templates.get(tmpl))
    	 	 @rerender()
      toogleall: () ->
        toggleTo = $('#checkboxheader').checkbox("is checked")
        console.log("toogleall to " + toggleTo)
        if toggleTo == true
          $('.ui.fitted.toggle.row').checkbox('check')
        else
          $('.ui.fitted.toggle.row').checkbox('uncheck')
          
  	 afterRenderEvent: () ->
    	 console.log("PersonView afterRender")
      $('.ui.fitted.toggle').checkbox()
