package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_expression.view.*
import net.objecthunter.exp4j.ExpressionBuilder


var lista = ArrayList<Operation>()
class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private var ultimo = ""
    private val VISOR_KEY = "visor"

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        text_visor.text = savedInstanceState?.getString(VISOR_KEY)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.run { putString(VISOR_KEY, text_visor.text.toString()) }
        super.onSaveInstanceState(outState)
    }
    override fun onDestroy() {
        Log.i(TAG,"o metodo onDestroy foi invocado")
        super.onDestroy()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "o metodo onCreate foi invocado")
        setContentView(R.layout.activity_main)
        list_historic?.layoutManager = LinearLayoutManager(this)
        list_historic?.adapter = HistoryAdapter(this, R.layout.item_expression, lista)
    }

        fun onClickHistorico(view: View) {
            startActivity(Intent(this, HistoryActivity::class.java))
            finish()
        }
        fun onClickDeleteAll(view: View) {
            Log.i(TAG, "Click no botão C")
            text_visor.setText("0")
        }
        fun onClickSymbol(view: View) {
            val symbol = view.tag.toString()
            Log.i(TAG, "Click no botão ${symbol}")
            if (text_visor.text.toString() == "0") {
                text_visor.text = symbol
            } else {
                text_visor.append(symbol)
            }
        }
        fun onClickDelLastCharacter(view: View) {
            Log.i(TAG, "Click no botão <")
            if (text_visor.length() > 1) {
                val texto = text_visor.text.substring(0, text_visor.length() - 1)
                text_visor.text = texto.toString()
            } else {
                text_visor.setText("0")
            }
        }
        fun onClickEquals(view: View) {
            Log.i(TAG, "Click no botão =")
            // Operation operation
            var expressao = text_visor.text.toString()
            ultimo = text_visor.text.toString()
            val expression = ExpressionBuilder(text_visor.text.toString()).build()
            text_visor.text = expression.evaluate().toString()
            Log.i(TAG, "O resutlado da expressão é ${text_visor.text}")
            var resultado = text_visor.text.toString()
            lista.add(Operation(expressao, resultado.toDouble()))
            list_historic?.layoutManager = LinearLayoutManager(this)
            list_historic?.adapter = HistoryAdapter(this, R.layout.item_expression, lista)

        }
}
class HistoryAdapter(private val context: Context, private val layout: Int, private val items: MutableList<Operation>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
        class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val expression : TextView = view.text_expression
            val resultado : TextView = view.text_result
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(LayoutInflater.from(context).inflate(layout,parent,false))
        }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.expression.text = items[position].expression
        holder.resultado.text = items[position].resultado.toString()
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Resutaldo do item "+position+" é " + lista[position].resultado,Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = items.size

}
class Operation(var expression : String,var resultado : Double)


