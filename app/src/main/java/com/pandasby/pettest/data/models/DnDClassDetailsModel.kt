package com.pandasby.pettest.data.models

import com.google.gson.annotations.SerializedName

data class DnDClassDetailsModel(
    @SerializedName("tabs") val tabs: List<DnDClassTabModel>?
)

data class DnDClassTabModel(
    @SerializedName("name") val tabName: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("url") val url: String?
)