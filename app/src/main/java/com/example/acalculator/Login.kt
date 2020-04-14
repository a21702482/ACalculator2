package com.example.acalculator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Optional
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_calculator.*

class Login : AppCompatActivity() {

var users = ArrayList<User>()
    var email = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this)
        users.add(User("teste","teste","teste@gmail.com"))
        if(intent.getParcelableArrayListExtra<User>("lista")!=null)
        {
            users = intent.getParcelableArrayListExtra<User>("lista")
        }
    }
    @Optional
    @OnClick(R.id.btn_Login)
    fun login() {
        if(verificar()==true)
        {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user",User(txt_username_login.text.toString(),txt_pwd_login.text.toString(),email))
            startActivity(intent)
            finish()
        }
    }
    @Optional
    @OnClick(R.id.btn_Register)
    fun registo() {
        val intent = Intent(this, Registo::class.java)
        intent.apply { putExtra("lista", users) }
        startActivity(intent)
        finish()
    }
    fun verificar() : Boolean
    {
        for(user in users)
        {
            if(txt_username_login.text.toString()==user.Username && txt_pwd_login.text.toString().compareTo(user.Password)==0)
            {
                email = user.email;
                return true
            }
        }
        return false
    }
}
