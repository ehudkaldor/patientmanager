define ["App", "ember", "controllers/StaffController"], (App, Ember) ->
  App.StaffRoute = Ember.Route.extend
    activate: () ->
      document.title = "appName" + " - Staff"
#    controllerName: "IndexController"
    renderTemplate: () ->
      @render(
        into: 'application',
        controllerName: 'StaffController'
#        outlet: 'main'
      )

    model: ->
      console.log("staff route")
