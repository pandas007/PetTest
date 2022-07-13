package com.pandasby.pettest.data

import org.json.JSONObject

object Extencions {

    fun String.toJson() = JSONObject(
        this
    )
}