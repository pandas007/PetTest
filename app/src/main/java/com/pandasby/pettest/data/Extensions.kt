package com.pandasby.pettest.data

import org.json.JSONObject

object Extensions {

    fun String.toJson() = JSONObject(
        this.trimIndent()
    )
}