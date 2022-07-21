package com.pandasby.pettest.data.api

import com.pandasby.pettest.data.Extencions.toJson
import com.pandasby.pettest.data.models.DnDClassDetailsModel
import com.pandasby.pettest.data.models.DnDClassModel
import org.json.JSONObject
import retrofit2.http.*

interface DnDService {

    @POST("api/v1/classes")
    @Headers("Content-Type: application/json")
    suspend fun fetchClasses(@Body rawBody: JSONObject =
        """
            {"page":0,"search":{"exact":false,"value":""},"order":[{"field":"name","direction":"asc"}],"filter":{"book":["PHB","TCE","DMG","XGE","FTD","SCAG","GGR","EGtW","VRGR"],"hitdice":[]}}
        """.trimIndent().toJson()
    ): List<DnDClassModel>

    @POST("api/v1{details_endpoint}")
    suspend fun fetchClassDetails(
        @Path("details_endpoint") detailsUrl: String,
        @Body body: JSONObject = """{"filter":{"book":["PHB","TCE","DMG","XGE","FTD","SCAG","GGR","EGtW","VRGR"],"hitdice":[]}}"""
            .trimIndent().toJson()
    ): DnDClassDetailsModel
}