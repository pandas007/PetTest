package com.pandasby.pettest.data.api

import com.pandasby.pettest.data.Extencions.toJson
import com.pandasby.pettest.data.models.DnDClassModel
import org.json.JSONObject
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface DnDService {

    @POST("api/v1/classes")
    @Headers("Content-Type: application/json")
    suspend fun fetchClasses(@Body rawBody: JSONObject =
        """
            {"page":0,"search":{"exact":false,"value":""},"order":[{"field":"name","direction":"asc"}]}
        """.toJson()
    ): List<DnDClassModel>
}