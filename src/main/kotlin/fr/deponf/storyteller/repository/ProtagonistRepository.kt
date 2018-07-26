package fr.deponf.storyteller.repository

import fr.deponf.storyteller.model.Protagonist
import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository

interface ProtagonistRepository : CrudRepository<Protagonist, ObjectId>