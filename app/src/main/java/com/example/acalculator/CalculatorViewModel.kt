package com.example.acalculator

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val calculatorLogic = CalculatorLogic()
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