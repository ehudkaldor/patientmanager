define ["App", "ember", "text!../templates/persons.handlebars", "semantic"], (App, Ember, tpl) ->
  App.PersonsView = Ember.View.extend
    defaultTemplate: Ember.Handlebars.compile(tpl)
#    name: "PersonView"
    actions:
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
