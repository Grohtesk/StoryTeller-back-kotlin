package fr.deponf.storyteller.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias

@TypeAlias("story")
data class Story (
        @Id var title: String,
        var pitch: String? = null,
        val map: Map? = null,
        var protagonists: List<Protagonist> = ArrayList(),
        val timeline: Timeline = Timeline(),
        val description: String? = null){
    override fun toString() = "titre: $title, protagonists : "+protagonists.count()
}

data class Map (val regions: List<String>,var locations: List<Location>)

data class Timeline (var events: List<Event> = ArrayList())

data class Event (val time: Long, val summary:String, var protagonists: List<Protagonist> = ArrayList())

class Location (val name: String, val x:Long,val y:Long)