package com.example.thermostat.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Bungalow {


    @SerializedName("id")
    @Expose
     var id: Int? = null

    @SerializedName("number")
    @Expose
     var number: Int? = null

    @SerializedName("temperature")
    @Expose
     var temperature: Double? = null

    @SerializedName("welcomeMessage")
    @Expose
    private var welcomeMessage: String? = null

    @SerializedName("cvIpAddress")
    @Expose
    private var cvIpAddress: String? = null

}