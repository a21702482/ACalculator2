package com.example.acalculator.ui.activities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Operation(var expression : String,var resultado : Double) {
    @PrimaryKey
    var uuid: String = UUID.randomUUID().toString()
}