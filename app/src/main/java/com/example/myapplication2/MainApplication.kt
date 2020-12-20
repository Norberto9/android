package com.example.myapplication2

import android.app.Application
import android.content.Context

/*Az appContext változó szükséges a room működéséhez*/

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        MainApplication.appContext = applicationContext
    }
    companion object{
        lateinit var appContext: Context
    }
}