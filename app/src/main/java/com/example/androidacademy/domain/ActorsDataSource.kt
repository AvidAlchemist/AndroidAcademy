package com.example.androidacademy.domain

import com.example.androidacademy.R
import com.example.androidacademy.data.models.Actor

class ActorsDataSource {
    fun getActors() : List<Actor> {
        return listOf(
            Actor(R.drawable.robert_downey_jr, "Robert Downey Jr."),
            Actor(R.drawable.chris_evans, "Chris Evans"),
            Actor(R.drawable.chris_hemsworth, "Chris Hemsworth"),
            Actor(R.drawable.mark_ruffalo, "Mark Ruffalo")
        )
    }
}