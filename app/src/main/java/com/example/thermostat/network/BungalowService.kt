package com.example.thermostat.network

import com.example.thermostat.Bungalow
import com.example.thermostat.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BungalowService {

    @GET(Constants.idValue)
    suspend fun getSingleBungalow() : Response<Bungalow>

    @GET()
    suspend fun getBungalows() : Response<List<Bungalow>>


    companion object {
        operator fun invoke(): BungalowService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.baseUrl)
                .build()
                .create(BungalowService::class.java)
        }
    }
}