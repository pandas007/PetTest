package com.pandasby.pettest.domain.entities

data class DnDClass(
    val name: String,
    val dice: String,
    val imageUrl: String,
    val detailsUrl: String,
    var details: DnDClassDetails? = null
)
