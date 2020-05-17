package com.example.acalculator.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.acalculator.domain.calculator.HistoryLogic
import com.example.acalculator.ui.activities.Operation
import com.example.acalculator.ui.listeners.onListChanged
import java.util.ArrayList

class HistoryViewModel : ViewModel() {
    private val historyViewModel =
        HistoryLogic()
    private var listener: onListChanged? = null
    private var list = ArrayList<Operation>()



    private fun notifyOnDisplayChanged(){
        listener?.onListChanged(list)
    }
    fun registerListener(listener: onListChanged){
        this.listener = listener
        listener.onListChanged(list)
    }
    fun unregisterListener() {
        listener = null
    }

    fun onClickList(indice: Int){
        list = historyViewModel.clickList(list,indice)
        notifyOnDisplayChanged()
    }
}