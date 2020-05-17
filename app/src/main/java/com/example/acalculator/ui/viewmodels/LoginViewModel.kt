package com.example.acalculator.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.acalculator.UserLogado
import com.example.acalculator.data.remote.RetrofitBuilder
import com.example.acalculator.domain.auth.AuthLogic
import com.example.acalculator.ui.listeners.LoginExecutado

var userLogado: UserLogado?= UserLogado("","")
const val ENDPOINT = "https://cm-calculadora.herokuapp.com/api/"

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val authLogic = AuthLogic(RetrofitBuilder.getInstance(ENDPOINT), userLogado)

    fun onClickLogin(email: String, password: String) {
        authLogic.authenticateUser(email, password)
    }

    fun registerListener(listener: LoginExecutado)
    {
        authLogic.registerListener(listener)
    }


}