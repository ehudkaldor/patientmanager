define ["App", "ember", "text!../templates/person_edit.handlebars", "semantic"], (App, Ember, tpl) ->
  App.PersonEditView = Ember.View.extend
    defaultTemplate: Ember.Handlebars.compile(tpl)
    
    locked = true
    genderOption = ["male", "female"]

    actions:
      unlock: ->
      	 locked = !locked
      	 if (locked)
      	 	 $('#unlock_button').removeClass('red').addClass('green')
      	 	 $('#unlock_button').text('Unlock')
      	 	 $('#lock').removeClass('unlock').addClass('lock')
      	 else
          $('#unlock_button').removeClass('green').addClass('red')
          $('#unlock_button').text('Lock')
          $('#lock').removeClass('lock').addClass('unlock')
        console.log($('#unlock_button').attr('class'))
        console.log("locked=" + locked)
        return false
          
    afterRenderEvent: () ->
      console.log("PersonEditView afterRender")
#      $('#unlock_button').state(
#        text: 
#          inactive : 'Unlock',
#          active   : 'Lock'
#      )
#      $('.ui.dropdown')
#        .dropdown()
      $('#gender')
        .dropdown(
#          "set selected", gender
        )
      if (locked)
        $('#unlock_button').removeClass('red').addClass('green')
        $('#unlock_button').text('Unlock')
        $('#lock').removeClass('unlock').addClass('lock')
      else
        $('#unlock_button').removeClass('green').addClass('red')
        $('#unlock_button').text('Lock')
        $('#lock').removeClass('lock').addClass('unlock')
      
      