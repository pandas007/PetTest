package com.pandasby.pettest.data

import com.google.gson.JsonParser


object Extensions {

    fun String.toJson() = JsonParser.parseString(this.trimIndent()).asJsonObject
}