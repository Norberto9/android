package com.example.myapplication2.retrofit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Restaurants(
    @Expose @SerializedName("total_entries") val total_entries: Int,
    @Expose @SerializedName("per_page") val per_page: Int,
    @Expose @SerializedName("current_page") val current_page: Int,
    @Expose @SerializedName("restaurants") val restaurants: List<Restaurant>
)