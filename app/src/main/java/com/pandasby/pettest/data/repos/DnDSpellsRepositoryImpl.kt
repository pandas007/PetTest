package com.pandasby.pettest.data.repos

import com.pandasby.pettest.data.Extensions.toJson
import com.pandasby.pettest.data.api.DnDRequestBodies.createSpellRequestBody
import com.pandasby.pettest.data.api.DnDService
import com.pandasby.pettest.data.models.Mappers.toEntity
import com.pandasby.pettest.domain.entities.spells.DnDSpell
import com.pandasby.pettest.domain.repos.DnDSpellsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DnDSpellsRepositoryImpl @Inject constructor(
    private val service: DnDService
) : DnDSpellsRepository {

    override suspend fun getClassSpells(classSpellsId: String): List<DnDSpell> =
        service.fetchClassSpells(
            createSpellRequestBody(classSpellsId).toJson()
        ).map { it.toEntity() }
}