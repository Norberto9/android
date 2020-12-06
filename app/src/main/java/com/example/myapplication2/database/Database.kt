package com.example.myapplication2.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Restaurant::class, User::class), version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
    abstract fun userDao(): UserDao
}