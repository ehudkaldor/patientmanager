require.config
  paths:
    jQuery:     "../third/jquery-2.1.1.min"
    handlebars: "../third/handlebars-v2.0.0"
    semantic: "../third/semantic.1.7.1.min"
    ember:      "../third/ember.1.10.beta.prod"
    'ember-data': "../third/ember-data.1.10.beta.prod",
    text: "../third/text"
#    templates: "../third/templates/"
    
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
