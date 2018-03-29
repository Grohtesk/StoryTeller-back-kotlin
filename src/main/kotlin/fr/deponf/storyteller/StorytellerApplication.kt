package fr.deponf.storyteller

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StorytellerApplication

fun main(args: Array<String>) {
    runApplication<StorytellerApplication>(*args)
}
