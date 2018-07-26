package fr.deponf.storyteller.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Story (
        @Id var id: String = "",
        var title: String = "",
        var subtitle: String? = null,
        var pitch: String? = null,
        val map: Map? = null,
        @DBRef var protagonists: List<Protagonist> = ArrayList(),
        val timeline: Timeline = Timeline()){

    override fun toString() = "titre: $title, protagonists : "+protagonists.count()
}