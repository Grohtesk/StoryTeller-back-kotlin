package fr.deponf.storyteller.model.service

import fr.deponf.storyteller.model.Protagonist
import fr.deponf.storyteller.service.StoryService
import fr.deponf.storyteller.model.StoryTellerTestWithFongo
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import kotlin.test.assertEquals

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
		STORY_1.pitch="Cool story, bro"
		storyService.save(STORY_1)
		assertEquals("Cool story, bro", storyService.findByTitle(STORY_1.title)?.pitch)
	}

	@Test
	fun testAddProtagonist() {
		STORY_1.protagonists += Protagonist("Chorum", "Le dévoreur")
		storyService.save(STORY_1)
		assertEquals(2,storyService.findByTitle(STORY_1.title)?.protagonists?.size)
	}
}
