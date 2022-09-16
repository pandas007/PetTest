package com.pandasby.pettest.domain.usecases

import com.pandasby.pettest.domain.entities.spells.DnDSpell
import com.pandasby.pettest.domain.entities.spells.DnDSpellDetails
import com.pandasby.pettest.domain.repos.DnDSpellsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DnDSpellsUseCase @Inject constructor(
    private val repository: DnDSpellsRepository
) : BaseUseCase() {

    suspend fun getClassSpells(classId: String): List<DnDSpell> = withContext(dispatcherIO) {
        val spells = repository.getClassSpells(classId)

        //region start Fetch and fill spell details into DnDSpell
        val spellDetailsList = spells.map {
            async { getClassSpellDetails(it.detailsUrl) }
        }.awaitAll()
        withContext(dispatcherDefault) {
            spells.forEach { spell ->
                spell.details = spellDetailsList.find { it.url == spell.detailsUrl }
            }
        }
        //endregion
        return@withContext spells
    }

    private suspend fun getClassSpellDetails(detailsUrl: String): DnDSpellDetails = withContext(dispatcherIO) {
        repository.getSpellDetails(detailsUrl)
    }
}