package com.example.myapplication2.retrofit

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class City(
    @SerializedName("count")
    @Expose
    val count: Int,

    @SerializedName("cities")
    @Expose
    val cities: List<String?>

)