package com.example.thermostat.network;


import com.example.thermostat.Constants;
import com.example.thermostat.model.Bungalow;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Repo {

    // get single
    @GET(Constants.idValue)
    Call<Bungalow> getSingleBungalow();

    // get all
    @GET(Constants.baseUrl)
    Call<List<Bungalow>> getAllBungalows();

    //put single
    @PUT(Constants.tempUrl)
    Call<Bungalow> putBungalow(@Body Bungalow bungalow);

}