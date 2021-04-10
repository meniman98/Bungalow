package com.example.thermostat

import retrofit2.Response

interface BungalowService {

    suspend fun getSingleBungalow : Response<Bungalow>
}