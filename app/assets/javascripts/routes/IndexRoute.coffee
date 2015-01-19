define ["App", "ember", "controllers/IndexController"], (App, Ember) ->
  App.IndexRoute = Ember.Route.extend
#    controllerName: "IndexController"
    renderTemplate: () ->
      @render(
        into: 'application',
        controllerName: 'IndexController'
#        outlet: 'main'
      )

    model: ->
      console.log("index route")
