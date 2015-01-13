define ["App", "ember", "text!../templates/index.handlebars", "semantic"], (App, Ember, indexTPL) ->
  App.IndexView = Ember.View.extend
    defaultTemplate: Ember.Handlebars.compile(indexTPL)
    name: "IndexView"
  