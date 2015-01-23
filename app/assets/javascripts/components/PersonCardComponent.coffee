define ["App", "ember", "text!../templates/components/person-card.handlebars", "semantic"], (App, Ember, personCardComp) ->
  App.PersonCardComponent = Ember.Component.create(
    App.PersonCardComponent = Ember.Handlebars.compile(personCardComp)
  )