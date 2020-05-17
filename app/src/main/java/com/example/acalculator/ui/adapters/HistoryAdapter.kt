package com.example.acalculator.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import com.example.acalculator.ui.activities.Operation
import kotlinx.android.synthetic.main.item_expression.view.*
import java.util.ArrayList

class HistoryAdapter(private val context: Context,
                     private val layout: Int,
                     private val items: List<Operation>)
    : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private var listaHistorico : List<Operation> = ArrayList()

    init {
        listaHistorico = items
    }


    class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var expression: TextView = view.text_expression
        var resultado: TextView = view.text_result
        var ajudaContext: Context

        fun recebeHistorico(operation: Operation) {
            expression?.text = operation.expression
            resultado?.text = operation.resultado.toString()
        }

        init {
            ButterKnife.bind(this, itemView)
            ajudaContext = itemView.context

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            LayoutInflater.from(context).inflate(layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.recebeHistorico(listaHistorico[position])
       /* holder.expression.text = items[position].expression
        holder.resultado.text = items[position].resultado.toString()
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Resutaldo do item "+position+" é " + items[position].resultado,
                Toast.LENGTH_SHORT).show()
        }*/
    }

    override fun getItemCount() = listaHistorico.size

}