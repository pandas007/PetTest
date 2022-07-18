package com.pandasby.pettest.data.models

import com.google.gson.annotations.SerializedName

data class DnDClassModel(
    @SerializedName("name") val name: DnDClassNameModel?,
    @SerializedName("dice") val dice: String?,
    @SerializedName("url") val detailsUrl: String?,
    @SerializedName("image") val imageUrl: String?
)

data class DnDClassNameModel(
    @SerializedName("rus") val rusName: String?,
    @SerializedName("eng") val engName: String?
)
