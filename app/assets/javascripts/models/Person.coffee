define ["App", "ember", "ember-data"], (App, Ember, DS) ->
#  attr = DS.attr
#  App.PersonSerializer = DS.JSONSerializer.extend(DS.EmbeddedRecordsMixin,
#    attrs: 
#      name: {embedded: 'always'}
#  )
  
#  DS.JSONSerializer.reopen(
#    serializeBelongsTo: (record, json, relationship) ->
#      key = relationship.key
#      belongsToRecord = Ember.get(record, key)
#    
#      if (relationship.options.embedded == 'always') 
#        json[key] = belongsToRecord.serialize()
#      else
#        return this._super(record, json, relationship)
#  )

	 App.Person = DS.Model.extend 
	   name: DS.belongsTo('name', {embedded: 'always'})
	   gender: DS.attr()
#	   firstname: attr(),
#	 	 lastname: attr()
#    console.log("creating person. first: " + first)
  
#  App.Name.reopenClass (
#    FIXTURES: [
#      {
#        id: 10,
#        first: "first_1",
#        middle: "middle_1",
#        last: "last_1" 
#      },
#      {
#        id: 20,
#        first: "first_2",
#        middle: "middle_2",
#        last: "last_2" 
#      }
#    ]
#   
#  )
	 	 
	 App.Person.reopenClass (
	   FIXTURES: [
	     {
	       id: 1, 
	       name: 10,
	       gender: "male"
  	   },
	     {
 	      id: 2, 
        name: 20,
        gender: "female"
	     }
    ]
  )
  return