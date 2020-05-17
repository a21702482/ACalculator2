package com.example.acalculator

import com.example.acalculator.ui.listeners.LoginExecutado
import java.io.Serializable

class UserLogado(var email: String, var token: String): LoginExecutado {

    private var listener: LoginExecutado?=null

    override fun loginSucesso(value: UserLogado?)
    {
        listener?.loginSucesso(this)
    }

    fun newUserLogin(email: String, token: String)
    {
        this.email = email
        this.token = token
        loginSucesso(this)
    }

    fun registerListener(listener: LoginExecutado){
        this.listener = listener
    }
}