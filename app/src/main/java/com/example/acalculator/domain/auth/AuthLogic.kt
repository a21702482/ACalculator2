package com.example.acalculator.domain.auth

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.acalculator.UserLogado
import com.example.acalculator.data.remote.requests.Login
import com.example.acalculator.data.remote.services.AuthService
import com.example.acalculator.ui.activities.MainActivity
import com.example.acalculator.ui.listeners.LoginExecutado
import com.example.acalculator.ui.viewmodels.userLogado
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class AuthLogic(private val retrofit: Retrofit, private var user: UserLogado?) : LoginExecutado {


    fun authenticateUser(email: String, password: String) {
        val service = retrofit.create(AuthService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.login(Login(email, password))
            if (response.isSuccessful) {
                var token: String? = response.body()?.getToken()
                token?.let { userLogado?.newUserLogin(email, it) }
                loginSucesso(userLogado)
            } else {
                Log.i("erro", response.body().toString())
            }
        }
    }

    fun registerListener(listener: LoginExecutado) {
        user?.registerListener(listener)

    }

    override fun loginSucesso(value: UserLogado?) {
        user?.loginSucesso(value)
    }

}