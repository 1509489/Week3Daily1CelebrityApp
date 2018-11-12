package com.pixelart.week3daily1celebrityapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Celebrity(var name : String, var age : Int, var description : String, var celebrityType : String, var image : String) : Parcelable