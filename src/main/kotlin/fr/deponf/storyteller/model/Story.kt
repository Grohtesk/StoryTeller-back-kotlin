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