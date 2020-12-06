package com.example.myapplication2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM restaurant")
    fun getAll(): List<Restaurant>

    @Insert
    fun insertNewRestaurant(restaurant: Restaurant)
}