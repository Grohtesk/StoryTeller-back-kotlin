package fr.deponf.storyteller.service

import fr.deponf.storyteller.model.Protagonist
import fr.deponf.storyteller.repository.ProtagonistRepository
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface ProtagonistService {
    fun findById(id: ObjectId): Protagonist?
}

@Service("ProtagonistService")
class ProtagonitServiceImpl : ProtagonistService {

    @Autowired
    lateinit var protagonistRepository: ProtagonistRepository

    override fun findById(id: ObjectId): Protagonist? {
        return protagonistRepository.findById(id).orElse(null)
    }

}
