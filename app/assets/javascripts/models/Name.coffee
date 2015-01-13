define ["App", "ember", "ember-data"], (App, Ember, DS) ->
  attr = DS.attr
  App.Name = DS.Model.extend
    person: DS.belongsTo('person') 
    first: attr(),
    middle: attr(),
    last: attr()

  App.Name.reopenClass (
    FIXTURES: [
      {
        id: 10,
        first: "first_1",
        middle: "middle_1",
        last: "last_1" 
      },
      {
        id: 20,
        first: "first_2",
        middle: "middle_2",
        last: "last_2" 
      }
    ]
   
  )
    