package com.example.acalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.history_activity.*

class HistoryActivity : AppCompatActivity() {

    private val EXTRA = "texto"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_activity)
        val operations = intent.getParcelableArrayListExtra<Operation>(EXTRA)
        lista_historico?.layoutManager = LinearLayoutManager(this)
        lista_historico?.adapter = HistoryAdapter(this, R.layout.item_expression, operations)

        fun onClickHistorico() {}
        button_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putParcelableArrayListExtra(EXTRA,operations)
            startActivity(intent)
            finish()
        }
    }
}
