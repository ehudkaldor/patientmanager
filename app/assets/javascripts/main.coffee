require.config
  paths:
    jQuery:     "../javascripts/jquery-2.1.1.min"
    handlebars: "../javascripts/handlebars-v2.0.0"
    semantic: "../javascripts/semantic.min"
    ember:      "../javascripts/ember.1.10.beta.prod"
    'ember-data': "../javascripts/ember-data.1.10.beta.prod",
    text: "../javascripts/text"
#    templates: "../javascripts/templates/"
    
  shim:
    jquery:
      exports: "$"
    handlebars:
    	 exports: "handlebars"
    ember:
    	 deps: ["jQuery", "handlebars"]
    	 exports: "Ember"
    'ember-data':
      deps:[ 'ember'],
      exports:'DS'
#    templates:
#    	 deps: ["ember"],
#    	 exports: "Template"
#    application:
#    	 deps: ["ember"]
#    	 exports: "app"

require ["App", "router", "ember"], (App, Router, Ember) ->
#	 console.log("starting")
	 Ember.View.reopen(
    didInsertElement: () ->
      @_super()
      Ember.run.scheduleOnce('afterRender', @, @afterRenderEvent)
    afterRenderEvent: () ->
    	 console.log("raw View afterRender")
  )
   
  Router() 
  return