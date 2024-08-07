package com.example.androidacademy.data.models

import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.androidacademy.R

data class Movie (
    val image : Int,
    val age : String,
    val hasLike : Boolean,
    val tags : String,
    val rating : String,
    val name : String,
    val reviews : String,
    val mins : String
)