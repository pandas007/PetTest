package com.pandasby.pettest.domain.entities.spells

sealed class DnDSpellComponent(val symbol: Char) {
    object Verbal : DnDSpellComponent('V')
    object Somatic : DnDSpellComponent('S')
    class Material(val details: String): DnDSpellComponent('M')
}