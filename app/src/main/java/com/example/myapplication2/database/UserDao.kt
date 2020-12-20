package com.example.myapplication2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
/*Itt vannak a roommal kapcsolatos sql utasitások, amiket használok*/
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert
    fun insertNewUser(user: User)

    @Update
    fun updateUser(user: User)

}