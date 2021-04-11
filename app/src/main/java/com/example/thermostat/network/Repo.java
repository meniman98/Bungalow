package com.example.thermostat.network;


import com.example.thermostat.Constants;
import com.example.thermostat.model.Bungalow;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Repo {


    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET(Constants.idValue)
    Call<Bungalow> getSingleBungalow();


    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET(Constants.baseUrl)
    Call<List<Bungalow>> getAllBungalows();

}