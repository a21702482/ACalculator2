package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.graphics.Path
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Optional
import kotlinx.android.synthetic.main.fragment_calculator.*
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.history_activity.*

class HistoryFragment : Fragment() {

    private val EXTRA = "texto"

    private var ajudaAdapter: HistoryAdapter? = null
    private var layout: RecyclerView? = null
    private lateinit var viewModel: CalculatorViewModel
    private var operations : List<Operation> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        /*arguments?.let {
            operations = it.getParcelableArrayList(EXTRA)
        }*/
        val view = inflater?.inflate(R.layout.fragment_history, container, false)
        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        ButterKnife.bind(this, view)

        operations = viewModel.showAllOperations()
        ajudaAdapter = HistoryAdapter(context!!,R.layout.item_expression, operations)

        val tentativa = LinearLayoutManager(this.context)
        layout = view?.findViewById(R.id.lista_historico)
        layout?.layoutManager = tentativa
        layout?.adapter = ajudaAdapter


        return view
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/
    @Optional
    @OnClick(R.id.button_back)
    fun OnClickBack(view: View)
    {
        NavigationManager.goToCalculatorFragment(this.fragmentManager!!)
    }
}


