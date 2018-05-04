package fr.deponf.storyteller.controller

import fr.deponf.storyteller.model.Story
import fr.deponf.storyteller.service.StoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
class StoryController{

    @Autowired
    lateinit var storyService: StoryService

    @GetMapping("/story")
    fun getAllStories() = storyService.findAll()

    @PostMapping("/story")
    fun createStory(){
        storyService.save(story = Story("Sha Do"))
    }

    /*@GetMapping(value = "/story")
    fun getStory(id: String) = storyService.findById(id)*/
}