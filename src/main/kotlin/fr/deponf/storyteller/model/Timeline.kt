package fr.deponf.storyteller.model

data class Timeline (var events: List<Event> = ArrayList()) {
    fun addEvent(event: Event){
        events += event
    }
}