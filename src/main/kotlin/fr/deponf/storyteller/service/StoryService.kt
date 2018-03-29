package fr.deponf.storyteller.service

import fr.deponf.storyteller.repository.StoryRepository
import fr.deponf.storyteller.model.Story
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


interface StoryService {
    fun findByTitle(title: String):Story?
    fun save(story: Story):Story
}

@Service("StoryService")
class StoryServiceImpl : StoryService {
    @Autowired
    lateinit var storyRepository: StoryRepository

    override fun findByTitle(title: String): Story? = storyRepository.findById(title).orElse(null)
    override fun save(story: Story): Story = storyRepository.save(story)
}