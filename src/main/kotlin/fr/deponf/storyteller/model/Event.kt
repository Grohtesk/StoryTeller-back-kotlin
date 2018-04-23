package fr.deponf.storyteller.model

data class Event (val time: Long,
                  val summary:String,
                  var description: String? = null,
                  var protagonists: List<Protagonist> = ArrayList(),
                  var location: Location? = null)