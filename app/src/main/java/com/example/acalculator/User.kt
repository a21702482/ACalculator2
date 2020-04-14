package com.example.acalculator

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User (
    var Username: String,
    var Password: String,
    var email: String
) : Parcelable


