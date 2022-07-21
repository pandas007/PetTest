package com.pandasby.pettest.domain.entities


data class DnDClassDetails(
    val tabs: List<DnDClassTab>
)

data class DnDClassTab(
    val name: String,
    val type: Type,
    val url: String,
) {
    enum class Type(val typeName: String) {
        TRAITS("traits"),
        DESCRIPTION("description"),
        SPELLS("spells"),
        UNKNOWN("");

        companion object {
            fun getTypeByName(name: String) =
                values().find { it.typeName == name } ?: UNKNOWN
        }
    }
}
