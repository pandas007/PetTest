package com.pandasby.pettest.domain.repos

import com.pandasby.pettest.domain.entities.spells.DnDSpell
import com.pandasby.pettest.domain.entities.spells.DnDSpellDetails

interface DnDSpellsRepository {

    suspend fun getClassSpells(classSpellsId: String): List<DnDSpell>

    suspend fun getSpellDetails(detailsUrl: String): DnDSpellDetails
}