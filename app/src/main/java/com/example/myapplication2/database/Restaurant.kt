package com.example.myapplication2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Restaurant(
    @PrimaryKey (autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "address") val address: String?,
    @ColumnInfo(name = "city") val city: String?,
    @ColumnInfo(name = "state") val state: String?,
    @ColumnInfo(name = "area") val area: String?,
    @ColumnInfo(name = "postal_code") val postal_code: Int?,
    @ColumnInfo(name = "country") val country: String?,
    @ColumnInfo(name = "phone") val phone: String?,
    @ColumnInfo(name = "lat") val lat: Float?,
    @ColumnInfo(name = "lng") val lng: Float?,
    @ColumnInfo(name = "price") val price: Float?,
    @ColumnInfo(name = "reserve_url") val reserve_url: String?,
    @ColumnInfo(name = "mobile_reserve_url") val mobile_reserve_url: String?,
    @ColumnInfo(name = "image_url") val image_url: String?
)