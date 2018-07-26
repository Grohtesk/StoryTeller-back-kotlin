package fr.deponf.storyteller.repository

import fr.deponf.storyteller.model.Story
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository

interface StoryRepository : CrudRepository<Story, ObjectId>{
    fun findOneByTitle(title:String): Story
}