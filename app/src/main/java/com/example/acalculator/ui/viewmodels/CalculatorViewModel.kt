package com.example.acalculator.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.acalculator.domain.calculator.CalculatorLogic
import com.example.acalculator.ui.activities.Operation
import com.example.acalculator.ui.listeners.onDisplayChanged

class CalculatorViewModel(application: Application) : AndroidViewModel(application) {

    private val storage = CalculatorDatabase.getInstance(application).operationDao()
    private val calculatorLogic = CalculatorLogic(storage)
    private var listener: onDisplayChanged? = null
    var display : String =""


    private fun notifyOnDisplayChanged(){
        listener?.onDisplayChanged(display)
    }
    fun registerListener(listener: onDisplayChanged){
        this.listener = listener
        listener.onDisplayChanged(display)
    }
    fun unregisterListener() {
        listener = null
    }

    fun onClickSymbol(symbol: String){
        display = calculatorLogic.insertSymbol(display, symbol)
        notifyOnDisplayChanged()
    }
    fun onClickDelLastCharacter(){
       display = calculatorLogic.delLastChar(display)
        notifyOnDisplayChanged()
    }
    fun onClickDeleteAll(){
        display = calculatorLogic.delAll()
        notifyOnDisplayChanged()
    }
    fun onClickEquals(){
       display = calculatorLogic.performOperation(display).toString()
       notifyOnDisplayChanged()
    }
    fun showAllOperations() : List<Operation>{
        return calculatorLogic.showOperations()
    }
}