package fr.deponf.storyteller.model

import com.github.fakemongo.junit.FongoRule
import fr.deponf.storyteller.repository.StoryRepository
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
abstract class StoryTellerTestWithFongo(val initializeTestData: Boolean = true){
    @get:Rule
    val fongoRule = FongoRule()

    @Autowired
    lateinit var storyRepository: StoryRepository

    @Before
    fun setupDatabase() {
        if (initializeTestData) {
            storyRepository.save(STORY_1)
            storyRepository.save(STORY_2)
            storyRepository.save(STORY_3)
        }
    }

    companion object {
        val STORY_1 = Story(title = "Sha Do")
        val STORY_2 = Story(title = "3 mermaids", protagonists = listOf(Protagonist(name = "Mira"), Protagonist(name = "Lylia"), Protagonist(name = "Sha")))
        val STORY_3 = Story(title = "Game of Thrones", protagonists = listOf(Protagonist(name = "Arya Stark")))
    }
}