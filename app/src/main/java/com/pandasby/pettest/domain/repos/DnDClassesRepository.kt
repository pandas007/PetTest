package com.pandasby.pettest.domain.repos

import com.pandasby.pettest.domain.entities.DnDClass

interface DnDClassesRepository {

    suspend fun getClasses(): List<DnDClass>
}