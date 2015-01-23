define ["App", "ember", "controllers/StaffController", "models/Staff", "views/StaffView"], (App, Ember) ->
  App.StaffRoute = Ember.Route.extend
    activate: () ->
      document.title = "appName" + " - Staff"

    renderTemplate: () ->
      @render(
        into: 'application',
        controllerName: 'StaffController'
#        outlet: 'main'
      )

    model: ->
      console.log("staff route")
      @store.find("name").then(
        () => @store.find("staff")
      )
      