package com.example.thermostat.presenter;

import com.example.thermostat.model.Bungalow;

import java.util.List;

public interface ApiListener {



    void onSuccess(Bungalow bungalow);

    // cheeky overloaded method here
    void onSuccess(List<Bungalow> bungalows);


    void onError(Throwable t);
}
