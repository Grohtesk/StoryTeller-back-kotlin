package fr.deponf.storyteller.repository

import fr.deponf.storyteller.model.Story
import org.springframework.data.repository.CrudRepository

interface StoryRepository : CrudRepository<Story, String>{
    fun findOneByTitle(title:String): Story
}