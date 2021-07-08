package com.example.universitylist.networking

import com.example.universitylist.UnversityresponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface apiService{

    @GET("search")
    suspend fun getUniv(@Query("country")query:String): Response<List<UnversityresponseItem>>

}