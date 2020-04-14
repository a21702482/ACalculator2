package com.example.acalculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Optional
import kotlinx.android.synthetic.main.activity_registo.*


class Registo : AppCompatActivity() {
    var lista = ArrayList<User>()



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)
        ButterKnife.bind(this)
        lista = intent.getParcelableArrayListExtra<User>("lista")


    }
    @Optional
    @OnClick(R.id.btn_Register_registo)
    fun registar()
    {
        Toast.makeText(this, "Nao entrou", Toast.LENGTH_SHORT).show()
        if(txt_username.text.toString() != null && txt_pwd.text.toString() != null && txt_pwd2.text.toString() != null && txt_email.text.toString()!=null)
        {
            if(txt_pwd.text.toString().compareTo(txt_pwd2.text.toString())==0)
            {
                Toast.makeText(this, "ADICIONOU", Toast.LENGTH_SHORT).show()
                lista.add(User(txt_username.text.toString(),txt_pwd.text.toString(),txt_email.text.toString()))
                val intent = Intent(this, Login::class.java)
                intent.apply { putExtra("lista", lista) }
                startActivity(intent)
                finish()
            }
        }
    }
}
