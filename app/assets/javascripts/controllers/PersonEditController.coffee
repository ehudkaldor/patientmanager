define ["App", "ember", "ember-data"], (App, Ember, DS) ->
  App.PersonEditController = Ember.ObjectController.extend

    isEditable: false
    actions:
#    	 edit: ->
#    	 	 alert("edit")
#    	 	 return false
    	 	 
    	 editMode: (editable) ->
    	 	 isEditable = editable
    	 	 console.log("changed Person edit-mode to " + isEditable)
    	 	  
      managehost: (id) ->
        console.log("managehost id=" + id)
        
    console.log("PersonEditController created")  