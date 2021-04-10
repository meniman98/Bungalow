package com.example.thermostat

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Bungalow {


    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("number")
    @Expose
    private var number: Int? = null

    @SerializedName("temperature")
    @Expose
    private var temperature: Double? = null

    @SerializedName("welcomeMessage")
    @Expose
    private var welcomeMessage: String? = null

    @SerializedName("cvIpAddress")
    @Expose
    private var cvIpAddress: String? = null

}