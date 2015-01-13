define ["App", "ember", "text!../templates/application.handlebars", "semantic"], (App, Ember, appTpl) ->
  App.ApplicationView = Ember.View.extend
    defaultTemplate: Ember.Handlebars.compile(appTpl)
    me: "ehud"
#    console.log("ApplicationView created. tpl: " + appTpl)
	   
