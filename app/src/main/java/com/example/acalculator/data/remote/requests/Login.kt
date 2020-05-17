package com.example.acalculator.data.remote.requests

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Login(@SerializedName("email")private var email: String, @SerializedName("password")private var password: String)
