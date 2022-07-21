package com.pandasby.pettest.data.models.spells

import com.google.gson.annotations.SerializedName

//That shit needs for getting class id for next fetching of spells collection
data class OtherForSpells(
    @SerializedName("other") val other: List<Other>?
) {
    data class Other(
        @SerializedName("key") val key: String?,
        @SerializedName("values") val values: List<Value>?
    )

    data class Value(
        @SerializedName("label") val label: String?,
        @SerializedName("key") val key: String?
    )
}