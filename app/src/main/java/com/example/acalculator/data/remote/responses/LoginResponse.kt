package com.example.acalculator.data.remote.responses

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

class LoginResponse(@SerializedName("email")private var email: String, @SerializedName("token")private var token: String) {

    fun getToken():String{
        return token
    }
}