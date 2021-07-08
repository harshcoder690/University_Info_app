package com.example.universitylist.networking

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Client {
    //this is done to set the naming policy
val gson = GsonBuilder()
    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
    .create()

val retrofit=Retrofit.Builder()
    .baseUrl("http://universities.hipolabs.com/")
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

val api= retrofit.create(apiService::class.java)

}