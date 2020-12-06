package com.example.myapplication2.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitRepository {
    val retrofit = Retrofit.Builder().baseUrl("http://opentable.herokuapp.com/").addConverterFactory(
        GsonConverterFactory.create()).build()
    val apiservice = retrofit.create(ApiService::class.java)


    fun getRepo(varos: String = "Atlanta"): Call<String?>? {
        return apiservice.listRepos(varos)

    }

    fun getCities(): Call<City?>{
        return apiservice.listCities()
    }

    fun getRestaurants(varos: String="Atlanta", ar: Int=1): Call<Restaurants> {
        return apiservice.listRestaurants(varos, ar)
    }
}

