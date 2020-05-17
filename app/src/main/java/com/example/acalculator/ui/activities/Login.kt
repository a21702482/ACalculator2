package com.example.acalculator.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Optional
import com.example.acalculator.R
import com.example.acalculator.User
import com.example.acalculator.UserLogado
import com.example.acalculator.ui.listeners.LoginExecutado
import com.example.acalculator.ui.viewmodels.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity(),LoginExecutado {

var users = ArrayList<User>()
    var email = String()
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        /*users.add(
            User(
                "teste",
                "teste",
                "teste@gmail.com"
            )
        )
        if(intent.getParcelableArrayListExtra<User>("lista")!=null)
        {
            users = intent.getParcelableArrayListExtra<User>("lista")
        }*/
    }

    override fun onStart() {
        super.onStart()
        loginViewModel.registerListener(this)
    }
    @Optional
    @OnClick(R.id.btn_Login)
    fun login() {
        loginViewModel.onClickLogin(txt_username_login.text.toString(),txt_pwd_login.text.toString())
    }
    @Optional
    @OnClick(R.id.btn_Register)
    fun registo() {
        val intent = Intent(this, Registo::class.java)
        intent.apply { putExtra("lista", users) }
        startActivity(intent)
        finish()
    }
    override fun loginSucesso(value: UserLogado?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
