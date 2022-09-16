package com.pandasby.pettest.data.api

import com.google.gson.JsonObject
import com.pandasby.pettest.data.Extensions.toJson
import com.pandasby.pettest.data.api.DnDRequestBodies.fetchClassDetailsBody
import com.pandasby.pettest.data.api.DnDRequestBodies.fetchClassesBody
import com.pandasby.pettest.data.models.DnDClassDetailsModel
import com.pandasby.pettest.data.models.DnDClassModel
import com.pandasby.pettest.data.models.spells.DnDSpellDetailsModel
import com.pandasby.pettest.data.models.spells.DnDSpellModel
import com.pandasby.pettest.data.models.spells.OtherForSpells
import retrofit2.http.*

interface DnDService {

    @POST("api/v1/classes")
    @Headers("Content-Type: application/json")
    suspend fun fetchClasses(
        @Body rawBody: JsonObject = fetchClassesBody.toJson()
    ): List<DnDClassModel>

    @POST("api/v1{details_endpoint}")
    suspend fun fetchClassDetails(
        @Path("details_endpoint") detailsUrl: String,
        @Body body: JsonObject = fetchClassDetailsBody.toJson()
    ): DnDClassDetailsModel

    @POST("api/v1{spells_url}")
    suspend fun getClassIdForSpells(@Path("spells_url") spellsUrl: String): OtherForSpells

    @POST("api/v1/spells")
    suspend fun fetchClassSpells(@Body rawBody: JsonObject): List<DnDSpellModel>

    @POST("api/v1{details_url}")
    suspend fun fetchSpellDetails(@Path("details_url") detailsUrl: String): DnDSpellDetailsModel
}