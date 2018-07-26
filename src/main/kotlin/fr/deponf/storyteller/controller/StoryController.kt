package fr.deponf.storyteller.controller

import fr.deponf.storyteller.model.Protagonist
import fr.deponf.storyteller.model.Story
import fr.deponf.storyteller.service.ProtagonistService
import fr.deponf.storyteller.service.StoryService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
class StoryController{

    @Autowired
    lateinit var storyService: StoryService

    @Autowired
    lateinit var protagonistService: ProtagonistService

    @GetMapping("/story")
    fun getAllStories(): List<Story> {
        return storyService.findAll()
    }

    @PostMapping("/story")
    fun save(@RequestBody story: Story){
        storyService.save(story)
    }

    @GetMapping("/story/{id}")
    fun getStory(@PathVariable id: ObjectId): Story?{
        return storyService.findById(id)
    }

    @GetMapping("/story/{storyId}/protagonist/{protagonistId}")
    fun getProtagonist(@PathVariable("protagonistId") id : ObjectId): Protagonist?{
        return protagonistService.findById(id)
    }

    /*@GetMapping(value = "/story")
    fun getStory(id: String) = storyService.findById(id)*/
}