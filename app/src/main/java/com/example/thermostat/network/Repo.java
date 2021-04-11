package com.example.thermostat.network;


import com.example.thermostat.Constants;
import com.example.thermostat.model.Bungalow;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Repo {

    @GET(Constants.idValue)
    Call<Bungalow> getSingleBungalow();

    @GET()
    Call<List<Bungalow>> getAllBungalows();

}