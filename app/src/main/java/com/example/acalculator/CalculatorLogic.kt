package com.example.acalculator

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorLogic{

    private val storage = ListStorage.getInstance()

    fun insertSymbol(display: String, symbol: String): String{
        return if(display.isEmpty() && symbol == "0") symbol else display+symbol
    }
    fun delAll(): String{
        return ""
    }
    fun delLastChar(display: String): String{
        if (display.length > 1)
        {
            return display.substring(0,display.length-1)
        }
       return ""
    }
    fun performOperation(expression: String): Double {
        val expressionBuilder = ExpressionBuilder(expression).build()
        val  result = expressionBuilder.evaluate()
        CoroutineScope(Dispatchers.IO).launch {
            storage.insert(Operation(expression,result))
        }
        return result

    }
    fun showOperations() : List<Operation>
    {
        return storage.getAll()
    }
}