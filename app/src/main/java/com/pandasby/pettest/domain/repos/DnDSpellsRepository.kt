package com.pandasby.pettest.domain.repos

import com.pandasby.pettest.domain.entities.spells.DnDSpell

interface DnDSpellsRepository {

    suspend fun getClassSpells(classSpellsId: String): List<DnDSpell>
}