package fr.deponf.storyteller.service

import fr.deponf.storyteller.repository.StoryRepository
import fr.deponf.storyteller.model.Story
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


interface StoryService {
    fun save(story: Story):Story
    fun findByTitle(title: String):Story?
    fun findAll(): List<Story>
    fun findById(id: String): Story?
}

@Service("StoryService")
class StoryServiceImpl : StoryService {
    @Autowired
    lateinit var storyRepository: StoryRepository

    override fun save(story: Story): Story = storyRepository.save(story)

    override fun findByTitle(title: String): Story? = storyRepository.findOneByTitle(title)

    override fun findAll() = storyRepository.findAll().toList()

    override fun findById(id: String): Story? = storyRepository.findById(id).orElse(null)

}
