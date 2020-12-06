package com.example.myapplication2.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("api/restaurants")
    fun listRepos(@Query("city") varos: String="Atlanta"): Call<String?>?

    @GET("api/cities")
    fun listCities(): Call<City?>

    @GET("api/restaurants")
    fun listRestaurants(@Query("city") varos: String="Atlanta", @Query("price") ar: Int=1): Call<Restaurants>
}