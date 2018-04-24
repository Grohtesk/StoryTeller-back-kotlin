package fr.deponf.storyteller.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Field

@TypeAlias("story")
data class Story (
        var title: String,
        var pitch: String? = null,
        val map: Map? = null,
        var protagonists: List<Protagonist> = ArrayList(),
        val timeline: Timeline = Timeline()){
    @Id lateinit var id: String

    override fun toString() = "titre: $title, protagonists : "+protagonists.count()
}