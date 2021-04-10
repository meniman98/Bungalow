package com.example.thermostat

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Bungalow {


    @SerializedName("id")
    @Expose
    private val id: Int? = null

    @SerializedName("number")
    @Expose
    private val number: Int? = null

    @SerializedName("temperature")
    @Expose
    private val temperature: Double? = null

    @SerializedName("welcomeMessage")
    @Expose
    private val welcomeMessage: String? = null

    @SerializedName("cvIpAddress")
    @Expose
    private val cvIpAddress: String? = null

}