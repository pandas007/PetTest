package com.pandasby.pettest.domain.usecases

import com.pandasby.pettest.domain.entities.spells.DnDSpell
import com.pandasby.pettest.domain.repos.DnDSpellsRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DnDSpellsUseCase @Inject constructor(
    private val repository: DnDSpellsRepository
) : BaseUseCase() {

    suspend fun getClassSpells(classId: String): List<DnDSpell> = withContext(dispatcherIO) {
        repository.getClassSpells(classId)
    }

}