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
            storyRepository.save(STORY_2)
            storyRepository.save(STORY_1)
        }
    }

    companion object {
        val STORY_1 = Story(title = "Sha Do", protagonists = listOf(Protagonist("Ameth")))
        val STORY_2 = Story(title = "3 mermaids", protagonists = listOf(Protagonist("Mira"), Protagonist("Lylia"), Protagonist("Sha")))
    }
}