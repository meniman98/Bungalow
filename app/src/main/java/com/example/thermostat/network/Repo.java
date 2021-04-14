package com.example.thermostat.network;


import com.example.thermostat.Constants;
import com.example.thermostat.model.Bungalow;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

public interface Repo {

    // get single
    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET(Constants.idValue)
    Call<Bungalow> getSingleBungalow();

    // get all
    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET(Constants.baseUrl)
    Call<List<Bungalow>> getAllBungalows();

    //put single
    @PUT(Constants.idValue)
    Call<Bungalow> putBungallow(@Pa)

}