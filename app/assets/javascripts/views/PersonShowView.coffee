define ["App", "ember", "text!../templates/person_show.handlebars", "semantic"], (App, Ember, tpl) ->
  App.PersonShowView = Ember.View.extend
    defaultTemplate: Ember.Handlebars.compile(tpl)

#    actions:
          
    afterRenderEvent: () ->
      console.log("PersonShowView afterRender")
      $('.ui.fitted.toggle').checkbox()
