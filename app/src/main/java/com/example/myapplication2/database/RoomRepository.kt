package com.example.myapplication2.database

import androidx.room.Room
import com.example.myapplication2.MainApplication

/*A room fő része. */

class RoomRepository {
    val db = Room.databaseBuilder(
        MainApplication.appContext,
        AppDatabase::class.java, "database-name"
    ).fallbackToDestructiveMigration().build() // a room szerkezetének változása után kiüríti a room-ot

    val dao = db.restaurantDao()
    val daou = db.userDao()

    /*A Restaurant adatbázisból visszatériti az összes restaurantot*/
    fun getRestaurants(): List<Restaurant>{
        return dao.getAll()
    }

    /*Beszúr egy új éttermet*/
    fun addNewRestaurant(name: String)
    {
        var temp: Restaurant = Restaurant(0, name, null, null, null, null, null, null, null, null, null, null, null, null, null)

        dao.insertNewRestaurant(
            temp
        )
    }
    /*Lekéri az összes regisztrált usert*/
    fun getUsers(): List<User>{
        return daou.getAll()
    }
    /*Beszúr egy új usert*/
    fun addNewUser(user: User)
    {
        daou.insertNewUser(
            user
        )
    }
    /*Módosit egy adott user adatain*/
    fun updateUser(user: User)
    {
        daou.updateUser(user)
    }
}