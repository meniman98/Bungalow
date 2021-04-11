package com.example.thermostat.dataSource

import com.example.thermostat.model.Bungalow;
import com.example.thermostat.presenter.ApiListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class ApiRequest {


    private ApiListener apiListener;
    private Call<List<Bungalow>> callList;
    private Call<Bungalow> callBungalow;

    public ApiRequest(ApiListener apiListener) {
        this.apiListener = apiListener;
        callList =
    }
}

