define ["App", "ember-data", "ember", "models/Person", "models/Name", "controllers/PersonsController", "controllers/PersonEditController", "controllers/ApplicationController", "controllers/IndexController", "views/PersonsView", "views/IndexView", "views/ApplicationView", "views/PersonEditView"], (App, DS, Ember) ->
  console.log("creating router")
	 ->	 	 
    console.log("constructing routes in Router")
	
		  App.Router.map -> 
		  	 @resource('persons')
      @resource('person',  ->
        @route('show', {path: '/:person_id/show'})
        @route('edit', {path: '/:person_id/edit'})
        @route('delete', {path: '/:person_id/delete'})
        @route('new')
        return
      )
      return
    console.log("router constructed")
    
    App.ApplcationRoute = Ember.Route.extend
      controllerName: "ApplicationController"
      model: ->
        console.log("application route")
      
    App.IndexRoute = Ember.Route.extend
      controllerName: "IndexController"
      renderTemplate: () ->
        @render(
          into: 'application',
#          outlet: 'main'
        )

	     model: ->
        console.log("index route")
    
    App.PersonsRoute = Ember.Route.extend 
      controllerName: "PersonsController"
      renderTemplate: () ->
      	 console.log("rendering")
        @render(
          into: 'application',
#          outlet: 'main'
        )

	      model: ->
      	  console.log("persons route")
      	  @store.find("name").then(
      	    () => @store.find("person")
      	  )
    
    App.PersonShowRoute = Ember.Route.extend
      controllerName: "PersonShowController"
      renderTemplate: () ->
        @render(
          outlet: 'main',
        )

      model: (person) ->
        console.log("person.show")
#        console.log(person.person_id)
        @store.find("person", person.person_id)

    App.PersonEditRoute = Ember.Route.extend
      controllerName: "PersonEditController"
      renderTemplate: () ->
        @render(
          outlet: 'main',
        )

	     model: (person) ->
	     	 console.log("PersonEditRoute. person id: " + person.person_id)
        @store.find("name").then (
          () => @store.find("person", person.person_id)
        )
#        .then(
#          (p) => 
#            alert("p.name=" + p.name)
#            @store.find("name", p.name)
#        )
#        alert("person.edit")

    App.PersonDeleteRoute = Ember.Route.extend
      model: ->
#        alert("person.delete")

    App.PersonNewRoute = Ember.Route.extend
      model: ->
        return alert("person.new")
        