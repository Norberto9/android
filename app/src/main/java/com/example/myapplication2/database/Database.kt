package com.example.myapplication2.database

import androidx.room.Database
import androidx.room.RoomDatabase

/*A room adatbázis működéséhez szükséges class
* 2 táblát fog tartalmazni: egy user és egy restaurant táblákat*/

@Database(entities = arrayOf(Restaurant::class, User::class), version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
    abstract fun userDao(): UserDao
}