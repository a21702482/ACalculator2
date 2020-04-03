package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class CalculatorFragment : Fragment()
{
    private val TAG = MainActivity::class.java.simpleName
    private var ultimo = ""
    private val VISOR_KEY = "visor"
    private val EXTRA = "texto"
    var lista = ArrayList<Operation>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       /*if(intent.getParcelableArrayListExtra<Operation>(EXTRA)!=null)
        {
            lista = intent.getParcelableArrayListExtra<Operation>(EXTRA)
        }*/
     list_historic.layoutManager = LinearLayoutManager(activity as Context)
     list_historic.adapter = HistoryAdapter(activity as Context, R.layout.item_expression,lista)
     return inflater.inflate(R.layout.fragment_calculator,container,false)
    }

    /*fun onClickHistorico(view: View) {
        /*val intent = Intent(this, HistoryActivity::class.java)
        intent.putParcelableArrayListExtra(EXTRA,lista)
        startActivity(intent)
        finish()*/
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
        list_historic?.layoutManager = LinearLayoutManager(activity as Context)
        list_historic?.adapter = HistoryAdapter(activity as Context, R.layout.item_expression, lista)
        //falta qualquer coisa

    }*/
}
abstract class NavigationManager {
    companion object {
        private fun placeFragment(fm: FragmentManager, fragment: Fragment)
        {
            val transition = fm.beginTransaction()
            transition.replace(R.id.frame, fragment)
            transition.addToBackStack(null)
            transition.commit()
        }
        fun goToCalculatorFragment(fm: FragmentManager)
        {
            placeFragment(fm, CalculatorFragment())
        }
    }
}