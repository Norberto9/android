package com.example.myapplication2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
/*A User táblában lévő oszlopok meghatározása*/
@Entity
data class User (
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "regtime") val regtime: String?,
    @ColumnInfo(name = "lastlog") var lastlog: String?,
    @ColumnInfo(name = "password") val password: String?
)