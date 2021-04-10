package com.example.thermostat

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BungalowService {

    @GET("1")
    suspend fun getSingleBungalow() : Response<Bungalow>


    companion object {
        operator fun invoke(): BungalowService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://sbpbungalowparken.azurewebsites.net/bungalows/")
                .build()
                .create(BungalowService::class.java)
        }
    }
}