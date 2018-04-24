package fr.deponf.storyteller.model.service

import fr.deponf.storyteller.model.*
import fr.deponf.storyteller.service.StoryService
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class StorytellerServiceTest : StoryTellerTestWithFongo() {

	@Autowired
	lateinit var storyService: StoryService

	@Test
	fun testStoryCreation() {
		assertEquals(STORY_1, storyService.findByTitle("Sha Do"),"not the same story")
		assertEquals("Mira", storyService.findByTitle(STORY_2.title)
				?.protagonists?.first()?.name)
		assertEquals(3, storyService.findByTitle(STORY_2.title)?.protagonists?.size)
	}

	@Test
	fun testStoryUpdate() {
		val story: Story? = storyService.findByTitle(STORY_1.title)
		assertNotNull(story,"no story found with title ${STORY_1.title}")
		if(story!=null) {
			story.pitch = "Cool story, bro"
			storyService.save(story)
			assertEquals("Cool story, bro", storyService.findByTitle(STORY_1.title)?.pitch)
		}
	}

	@Test
	fun testAddProtagonist() {
		val story: Story? = storyService.findByTitle(STORY_1.title)
		assertNotNull(story,"no story found with title ${STORY_1.title}")
		if(story!=null) {
			story.protagonists += Protagonist("Chorum", "Le dévoreur")
			storyService.save(story)
			assertEquals(2, storyService.findByTitle(STORY_1.title)?.protagonists?.size)
		}
	}

	@Test
	fun testUpdateProtagonist() {
		val story = storyService.findByTitle(STORY_2.title)
		assertNotNull(story,"no story found with title ${STORY_1.title}")
		if(story!=null) {
			story.protagonists.first().description="A fallen angel"
			storyService.save(story)
			assertEquals("A fallen angel",storyService.findByTitle(STORY_2.title)?.protagonists?.first()?.description)
		}
	}

	@Test
	fun testUpdateProtagonistGender() {
		val story = storyService.findByTitle(STORY_2.title)
		assertNotNull(story,"no story found with title ${STORY_1.title}")
		if(story!=null) {
			story.protagonists.first().gender=Protagonist.Gender.MALE
			storyService.save(story)
			assertEquals(Protagonist.Gender.MALE,storyService.findByTitle(STORY_2.title)?.protagonists?.first()?.gender)
		}
	}

    @Test
    fun testUpdateTimeline() {
        val story = storyService.findByTitle(STORY_3.title)
        assertNotNull(story,"no story found with title ${STORY_3.title}")
        if(story!=null) {
            val description = "Under King Baratheon's command, Edd Stark leaves winterfell with Arya and Sansa. They bgin their journey to kingslanding"
            story.timeline.addEvent(Event(summary = "The starks leaves Winterfell", description = description, location = Location(name = "Winterfell", x = 1, y = 1), time = 0))
            storyService.save(story)
            assertEquals(1,storyService.findByTitle(STORY_3.title)?.timeline?.events?.size)
        }
    }

	@Test
	fun testGetId() {
		assertNotNull(storyService.findByTitle(STORY_1.title)?.id, "Id should not be null")
	}

	@Test
	fun testFindById() {
		assertEquals(STORY_2.title,storyService.findById(STORY_2.id)?.title, "could not find Story from Id: ${STORY_2.id}")
	}
}
