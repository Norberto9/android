package com.example.myapplication2.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    //@GET("restaurants")
    //fun listRepos(@Query("city") varos: String="Dallas"): Call<String?>?

    @GET("cities")
    fun listCities(): Call<City?>

    @GET("restaurants")
    fun listRestaurants(@Query("city") varos: String="Dallas", @Query("price") ar: Int=1): Call<Restaurants>
}