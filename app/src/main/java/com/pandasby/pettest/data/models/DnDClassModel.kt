package com.pandasby.pettest.data.models

import com.google.gson.annotations.SerializedName

data class DnDClassModel(
    @SerializedName("name") val name: DnDClassNameModel?
)

data class DnDClassNameModel(
    @SerializedName("rus") val rusName: String?,
    @SerializedName("eng") val engName: String?
)
