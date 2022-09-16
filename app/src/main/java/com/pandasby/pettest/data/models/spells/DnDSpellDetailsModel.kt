package com.pandasby.pettest.data.models.spells

import com.google.gson.annotations.SerializedName

data class DnDSpellDetailsModel(
    @SerializedName("description") val description: String?,
    @SerializedName("time") val time: String?,
    @SerializedName("range") val range: String?,
    @SerializedName("duration") val duration: String?,
    @SerializedName("url") val url: String?
)