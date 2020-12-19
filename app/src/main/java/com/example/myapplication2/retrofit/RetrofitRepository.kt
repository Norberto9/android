package com.example.myapplication2.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitRepository {
    val retrofit = Retrofit.Builder().baseUrl("https://ratpark-api.imok.space/").addConverterFactory(
        GsonConverterFactory.create()).build()

    val apiservice = retrofit.create(ApiService::class.java)


    /*fun getRepo(varos: String = "Dallas"): Call<String?>? {
        return apiservice.listRepos(varos)

    }*/

    fun getCities(): Call<City?>{
        return apiservice.listCities()
    }

    fun getRestaurants(varos: String="Dallas", ar: Int=1): Call<Restaurants> {
        return apiservice.listRestaurants(varos, ar)
    }
}

