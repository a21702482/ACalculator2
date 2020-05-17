package com.example.acalculator.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Optional
import com.example.acalculator.*
import com.example.acalculator.ui.activities.MainActivity
import com.example.acalculator.ui.activities.Operation
import com.example.acalculator.ui.listeners.onDisplayChanged
import com.example.acalculator.ui.utils.NavigationManager
import com.example.acalculator.ui.viewmodels.CalculatorViewModel
import kotlinx.android.synthetic.main.fragment_calculator.*
import kotlinx.android.synthetic.main.fragment_calculator.view.*


class CalculatorFragment : Fragment(), onDisplayChanged
{
    private  lateinit var viewModel: CalculatorViewModel
    private val TAG = MainActivity::class.java.simpleName
    private var ultimo = ""
    private val VISOR_KEY = "visor"
    private val EXTRA = "texto"
    private var lista : List<Operation> = ArrayList()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
     val view = inflater.inflate(R.layout.fragment_calculator, container,false)
     viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
     //lista = viewModel.showAllOperations()
     viewModel.display.let { view.text_visor.text = it }
     ButterKnife.bind(this, view)
     /*list_historic?.layoutManager = LinearLayoutManager(activity as Context)
     list_historic?.adapter = HistoryAdapter(activity as Context, R.layout.item_expression,lista)*/
     return view
    }

    override fun onDestroy() {
        viewModel.unregisterListener()
        super.onDestroy()
    }

    override fun onStart() {
        viewModel.registerListener(this)
        super.onStart()
    }
    override fun onDisplayChanged(value: String?)
    {
        value?.let { text_visor.text = it }
    }

    @Optional
    @OnClick(R.id.button_historico)
    fun onClickHistorico(view: View) {
        NavigationManager.goToHistoryFragment(
            this.fragmentManager!!
        )
        /*val intent = Intent(activity as Context, HistoryActivity::class.java)
        intent.putParcelableArrayListExtra(EXTRA,lista)
        startActivity(intent)*/
    }
    @Optional
    @OnClick(R.id.button_CE)
    fun onClickDeleteAll(view: View) {
        viewModel.onClickDeleteAll()
        /*Log.i(TAG, "Click no botão C")
        text_visor.setText("0")*/
    }
    @Optional
    @OnClick(
        R.id.button_0,
        R.id.button_00,
        R.id.button_1,
        R.id.button_2,
        R.id.button_3,
        R.id.button_4,
        R.id.button_5,
        R.id.button_6,
        R.id.button_7,
        R.id.button_8,
        R.id.button_9,
        R.id.button_add,
        R.id.button_divide,
        R.id.button_sub,
        R.id.button_multi,
        R.id.button_point
    )
    fun onClickSymbol(view: View) {
        viewModel.onClickSymbol(view.tag.toString())
        /*val symbol = view.tag.toString()
        Log.i(TAG, "Click no botão ${symbol}")
        if (text_visor.text.toString() == "0") {
            text_visor.text = symbol
        } else {
            text_visor.append(symbol)
        }*/
    }
    @Optional
    @OnClick(R.id.button_delone)
    fun onClickDelLastCharacter(view: View) {
        viewModel.onClickDelLastCharacter()
        /*Log.i(TAG, "Click no botão <")
        if (text_visor.length() > 1) {
            val texto = text_visor.text.substring(0, text_visor.length() - 1)
            text_visor.text = texto.toString()
        } else {
            text_visor.setText("0")
        }*/
    }
    @Optional
    @OnClick(R.id.button_equals)
    fun onClickEquals(view: View) {
        viewModel.onClickEquals()
        /*Log.i(TAG, "Click no botão =")
        // Operation operation
        var expressao = text_visor.text.toString()
        ultimo = text_visor.text.toString()
        val expression = ExpressionBuilder(text_visor.text.toString()).build()
        text_visor.text = expression.evaluate().toString()
        Log.i(TAG, "O resutlado da expressão é ${text_visor.text}")
        var resultado = text_visor.text.toString()
        lista.add(Operation(expressao, resultado.toDouble()))*/
        /*list_historic?.layoutManager = LinearLayoutManager(activity as Context)
        list_historic?.adapter = HistoryAdapter(activity as Context, R.layout.item_expression, lista)*/
        //falta qualquer coisa

    }
}