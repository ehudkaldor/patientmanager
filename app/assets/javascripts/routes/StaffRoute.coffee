define ["App", "ember", "controllers/StaffController"], (App, Ember) ->
  App.StaffRoute = Ember.Route.extend
#    controllerName: "IndexController"
    renderTemplate: () ->
      @render(
        into: 'application',
        controllerName: 'StaffController'
#        outlet: 'main'
      )

    model: ->
      console.log("staff route")
