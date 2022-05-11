package com.example.dagger2_example.models

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    @SerializedName("username")
    val userName: String,
    @SerializedName("email")
    val emailAddress: String
)