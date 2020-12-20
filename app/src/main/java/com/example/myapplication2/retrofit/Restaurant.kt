package com.example.myapplication2.retrofit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Restaurant(
    @Expose @SerializedName("id") val id: Long,
    @Expose @SerializedName("name") var name: String?,
    @Expose @SerializedName("address") val address: String?,
    @Expose @SerializedName("city") val city: String?,
    @Expose @SerializedName("state") val state: String?,
    @Expose @SerializedName("area") val area: String?,
    @Expose @SerializedName("postal_code") val postal_code: String?,
    @Expose @SerializedName("country") val country: String?,
    @Expose @SerializedName("phone") val phone: String?,
    @Expose @SerializedName("lat") val lat: Float?,
    @Expose @SerializedName("lng") val lng: Float?,
    @Expose @SerializedName("price") val price: Float?,
    @Expose @SerializedName("reserve_url") val reserve_url: String?,
    @Expose @SerializedName("mobile_reserve_url") val mobile_reserve_url: String?,
    @Expose @SerializedName("image_url") val image_url: String?
)