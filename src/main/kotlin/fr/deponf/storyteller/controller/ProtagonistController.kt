package fr.deponf.storyteller.controller

import fr.deponf.storyteller.model.Protagonist
import fr.deponf.storyteller.service.ProtagonistService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
class ProtagonistController{

    @Autowired
    lateinit var protagonistService: ProtagonistService


    @PostMapping("/protagonist")
    fun save(@RequestBody protagonist: Protagonist){
        protagonistService.save(protagonist)
    }

    @GetMapping("/protagonist/{protagonistId}")
    fun getProtagonist(@PathVariable("protagonistId") id : ObjectId): Protagonist?{
        return protagonistService.findById(id)
    }

    /*@GetMapping(value = "/story")
    fun getStory(id: String) = storyService.findById(id)*/
}