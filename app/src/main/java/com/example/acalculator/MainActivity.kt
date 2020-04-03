package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_expression.view.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigationManager.goToCalculatorFragment(supportFragmentManager)
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
            Toast.makeText(context, "Resutaldo do item "+position+" é " + items[position].resultado,Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = items.size

}
@Parcelize
class Operation(var expression : String,var resultado : Double) : Parcelable


