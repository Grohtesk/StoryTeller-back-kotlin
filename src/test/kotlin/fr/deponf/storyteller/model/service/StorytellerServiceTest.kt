package fr.deponf.storyteller.model.service

import fr.deponf.storyteller.model.Protagonist
import fr.deponf.storyteller.model.Story
import fr.deponf.storyteller.service.StoryService
import fr.deponf.storyteller.model.StoryTellerTestWithFongo
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
		var story: Story? = storyService.findByTitle(STORY_1.title)
		assertNotNull(story,"no story found with title ${STORY_1.title}")
		if(story!=null) {
			story.pitch = "Cool story, bro"
			storyService.save(story)
			assertEquals("Cool story, bro", storyService.findByTitle(STORY_1.title)?.pitch)
		}
	}

	@Test
	fun testAddProtagonist() {
		var story: Story? = storyService.findByTitle(STORY_1.title)
		assertNotNull(story,"no story found with title ${STORY_1.title}")
		if(story!=null) {
			story.protagonists += Protagonist("Chorum", "Le dévoreur")
			storyService.save(story)
			assertEquals(2, storyService.findByTitle(STORY_1.title)?.protagonists?.size)
		}
	}

	@Test
	fun testUpdateProtagonist() {
		var story = storyService.findByTitle(STORY_2.title)
		assertNotNull(story,"no story found with title ${STORY_1.title}")
		if(story!=null) {
			story.protagonists.first().description="A fallen angel"
			storyService.save(story)
			assertEquals("A fallen angel",storyService.findByTitle(STORY_2.title)?.protagonists?.first()?.description)
		}
	}

	@Test
	fun testUpdateProtagonistGender() {
		var story = storyService.findByTitle(STORY_2.title)
		assertNotNull(story,"no story found with title ${STORY_1.title}")
		if(story!=null) {
			story.protagonists.first().gender=Protagonist.Gender.MALE
			storyService.save(story)
			assertEquals(Protagonist.Gender.MALE,storyService.findByTitle(STORY_2.title)?.protagonists?.first()?.gender)
		}
	}
}
