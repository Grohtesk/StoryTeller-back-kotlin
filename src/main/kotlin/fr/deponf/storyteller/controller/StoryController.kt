package fr.deponf.storyteller.controller

import fr.deponf.storyteller.service.StoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StoryController{

    @Autowired
    lateinit var storyService: StoryService

    @GetMapping("/story")
    fun getAllStories() = storyService.findAll()

    /*@GetMapping(value = "/story")
    fun getStory(id: String) = storyService.findById(id)*/
}