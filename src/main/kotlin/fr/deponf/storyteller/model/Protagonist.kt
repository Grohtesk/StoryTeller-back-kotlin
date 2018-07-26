package fr.deponf.storyteller.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Protagonist (
        @Id var id: String = "",
        val name: String = "",
        val lastName: String? = null,
        val firstName: String? = null,
        var description: String? = null,
        var personality: String? = null,
        var background: String? = null,
        var gender:Gender = Gender.UNDEFINED,
        var main: Boolean = false) {

    enum class Gender(val txt:String){
        MALE("Masculin"),FEMALE("Féminin"),OTHER("Autre"),UNDEFINED("Indéfini")
    }
}