define ["App", "ember", "controllers/IndexController"], (App, Ember) ->
  App.IndexRoute = Ember.Route.extend
#    title: "title"
    activate: () ->
      document.title = "appName" + " - Home"

#    setupController: (controller) ->
#      controller.set('title', "My App")

#    controllerName: "IndexController"
    renderTemplate: () ->
      @render(
        into: 'application',
        controllerName: 'IndexController'
#        outlet: 'main'
      )

    model: ->
      console.log("index route")
