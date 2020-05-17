package com.example.acalculator.domain.calculator

import com.example.acalculator.data.local.list.ListStorage
import com.example.acalculator.ui.activities.Operation

class HistoryLogic{

    private val storage =
        ListStorage.getInstance()

    fun clickList(list: ArrayList<Operation>, indice: Int): ArrayList<Operation>{
        if(indice > storage.count())
        {
            list.removeAt(indice)
        }
        return list
    }
}