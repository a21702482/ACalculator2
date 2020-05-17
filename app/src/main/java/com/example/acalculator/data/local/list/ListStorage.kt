package com.example.acalculator.data.local.list

import com.example.acalculator.ui.activities.Operation

class ListStorage private constructor() {

    private val storage = mutableListOf<Operation>()

    companion object{

        private var instance: ListStorage? = null

        fun getInstance(): ListStorage {
            synchronized(this) {
                if(instance == null) {
                    instance =
                        ListStorage()
                }
                return instance as ListStorage
            }
        }
    }

    suspend fun insert(operation: Operation) {
      /*  withContext(Dispatchers.IO) {
            Thread.sleep(30000)
            storage.add(operation)
        }*/
        storage.add(operation)
    }
    fun count(): Int
    {
        return  storage.size
    }
    fun remove(indice: Int) {
       storage.removeAt(indice)
    }
    fun showOperations() : List<Operation>
    {
        return storage.toList()
    }

}