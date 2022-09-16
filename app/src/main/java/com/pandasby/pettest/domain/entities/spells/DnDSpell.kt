package com.pandasby.pettest.domain.entities.spells

data class DnDSpell(
    val nameRus: String,
    val nameEng: String,
    val level: Int,
    val components: List<DnDSpellComponent>,
    val source: String,
    val detailsUrl: String,
    var details: DnDSpellDetails? = null
)