package com.example.thermostat.network

import retrofit2.Response
import java.io.IOException

abstract class ApiRequest {


    suspend fun <T: Any> apiRequest(call: suspend () -> Response<T>) : T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        }
        else {
            //handle the error
            throw ApiException(response.code().toString())

        }
    }

}

class ApiException(message: String): IOException(message)