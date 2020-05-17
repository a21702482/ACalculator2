package com.example.acalculator.ui.fragments

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
import com.example.acalculator.*
import com.example.acalculator.ui.activities.Operation
import com.example.acalculator.ui.adapters.HistoryAdapter
import com.example.acalculator.ui.utils.NavigationManager
import com.example.acalculator.ui.viewmodels.CalculatorViewModel
import com.example.acalculator.ui.viewmodels.HistoryViewModel

class HistoryFragment : Fragment() {

    private val EXTRA = "texto"

    private var ajudaAdapter: HistoryAdapter? = null
    private var lista_layout: RecyclerView? = null
    private lateinit var viewModelCalculator: CalculatorViewModel
    private lateinit var viewModel: HistoryViewModel
    private var operations : List<Operation> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        /*arguments?.let {
            operations = it.getParcelableArrayList(EXTRA)
        }*/
        val view = inflater?.inflate(R.layout.fragment_history, container, false)
        viewModelCalculator = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        ButterKnife.bind(this, view)

        operations = viewModelCalculator.showAllOperations()
        ajudaAdapter = HistoryAdapter(
            context!!,
            R.layout.item_expression,
            operations
        )

        val tentativa = LinearLayoutManager(this.context)
        lista_layout = view?.findViewById(R.id.lista_historico)
        lista_layout?.layoutManager = tentativa
        lista_layout?.adapter = ajudaAdapter

        
        return view
    }



    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/


    @Optional
    @OnClick(R.id.button_back)
    fun OnClickBack(view: View)
    {
        NavigationManager.goToCalculatorFragment(
            this.fragmentManager!!
        )
    }
}


