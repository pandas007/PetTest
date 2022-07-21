package com.pandasby.pettest.data.models.spells

import com.google.gson.annotations.SerializedName

data class DnDSpellModel(
    @SerializedName("name") val name: DnDSpellNameModel?,
    @SerializedName("level") val level: Int?,
    @SerializedName("components") val components: DnDSpellComponentsModel?,
    @SerializedName("source") val source: DnDSpellSourceModel?,
    @SerializedName("url") val url: String?
) {
    data class DnDSpellComponentsModel(
        @SerializedName("s") val s: Boolean?,
        @SerializedName("v") val v: Boolean?,
        @SerializedName("m") val m: Boolean?,
    )

    data class DnDSpellNameModel(
        @SerializedName("rus") val rus: String?,
        @SerializedName("eng") val eng: String?
    )

    data class DnDSpellSourceModel(
        @SerializedName("name") val name: String?,
        @SerializedName("shortName") val shortName: String?
    )
}