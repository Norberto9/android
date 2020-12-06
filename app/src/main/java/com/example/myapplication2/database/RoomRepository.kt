package com.example.myapplication2.database

import androidx.room.Room
import com.example.myapplication2.MainApplication

class RoomRepository {
    val db = Room.databaseBuilder(
        MainApplication.appContext,
        AppDatabase::class.java, "database-name"
    ).fallbackToDestructiveMigration().build()

    val dao = db.restaurantDao()
    val daou = db.userDao()

    /*A Restaurant adatbázisból visszatériti az összes restaurantot*/
    fun getRestaurants(): List<Restaurant>{
        return dao.getAll()
    }

    fun addNewRestaurant(name: String)
    {
        var temp: Restaurant = Restaurant(0, name, null, null, null, null, null, null, null, null, null, null, null, null, null)

        dao.insertNewRestaurant(
            temp
        )
    }

    fun getUsers(): List<User>{
        return daou.getAll()
    }

    fun addNewUser(user: User)
    {
        daou.insertNewUser(
            user
        )
    }
}