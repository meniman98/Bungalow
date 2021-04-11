package com.example.thermostat.network

import com.example.thermostat.Bungalow
import retrofit2.Response

class Repo(
    private val service: BungalowService

) : BungalowService {

    override suspend fun getSingleBungalow(): Response<Bungalow> {
        service.getSingleBungalow()
    }

    override suspend fun getBungalows(): Response<List<Bungalow>> {
        service.getBungalows()
    }


}