package com.pandasby.pettest.data.repos

import com.pandasby.pettest.data.api.DnDService
import com.pandasby.pettest.data.models.Mappers.toEntity
import com.pandasby.pettest.domain.entities.DnDClass
import com.pandasby.pettest.domain.entities.DnDClassDetails
import com.pandasby.pettest.domain.repos.DnDClassesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DnDClassesRepositoryImpl @Inject constructor(
    private val service: DnDService
) : DnDClassesRepository {

    override suspend fun getClasses(): List<DnDClass> = service.fetchClasses().map { it.toEntity() }

    override suspend fun getClassDetails(detailsUrl: String): DnDClassDetails =
        service.fetchClassDetails(detailsUrl).toEntity()

    //Forgot about clean code in this func, no sense cause of backend. Should be in class details func, but it has not :(
    override suspend fun getClassIdForSpells(spellsUrl: String): String =
        service.getClassIdForSpells(spellsUrl)
            .other?.find { it.key == "class" }
            ?.values?.first()
            ?.key
            .orEmpty()
}