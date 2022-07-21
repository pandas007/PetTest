package com.pandasby.pettest.domain.repos

import com.pandasby.pettest.domain.entities.DnDClass
import com.pandasby.pettest.domain.entities.DnDClassDetails

interface DnDClassesRepository {

    suspend fun getClasses(): List<DnDClass>

    suspend fun getClassDetails(detailsUrl: String): DnDClassDetails

    suspend fun getClassIdForSpells(spellsUrl: String): String
}