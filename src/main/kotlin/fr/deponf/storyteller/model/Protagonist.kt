package fr.deponf.storyteller.model

data class Protagonist (
        val name: String,
        val lastName: String? = null,
        val firstName: String? = null,
        var description: String? = null,
        var personality: String? = null,
        var background: String? = null,
        var gender:Gender = Gender.UNDEFINED ) {
    enum class Gender(val txt:String){
        MALE("Masculin"),FEMALE("Féminin"),OTHER("Autre"),UNDEFINED("Indéfini")
    }
}