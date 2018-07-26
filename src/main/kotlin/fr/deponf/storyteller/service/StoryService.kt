package fr.deponf.storyteller.service

import fr.deponf.storyteller.repository.StoryRepository
import fr.deponf.storyteller.model.Story
import fr.deponf.storyteller.repository.ProtagonistRepository
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


interface StoryService {
    fun save(story: Story):Story
    fun findByTitle(title: String):Story?
    fun findAll(): List<Story>
    fun findById(id: ObjectId): Story?
}

@Service("StoryService")
class StoryServiceImpl : StoryService {
    @Autowired
    lateinit var storyRepository: StoryRepository
    @Autowired
    lateinit var protagonistRepository: ProtagonistRepository

    override fun save(story: Story): Story{
        story.protagonists.forEach({protagonistRepository.save(it)})
        return storyRepository.save(story)
    }

    override fun findByTitle(title: String): Story? = storyRepository.findOneByTitle(title)

    override fun findAll() = storyRepository.findAll().toList()

    override fun findById(id: ObjectId): Story? = storyRepository.findById(id).orElse(null)

}
