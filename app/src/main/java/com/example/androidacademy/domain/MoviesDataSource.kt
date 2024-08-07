package com.example.androidacademy.domain

import com.example.androidacademy.R
import com.example.androidacademy.data.models.Movie

class MoviesDataSource {
    fun getMovies() : List<Movie> {
        return listOf(
            Movie(R.drawable.avengers, "13+", false, "Action, Adventure, Fantasy",
                "4", "Avengers: End Game", "125 REVIEWS", "137 MIN"),
            Movie(R.drawable.tenet, "16+", true, "Action, Sci-Fi, Triller",
                "5", "Tenet", "98 REVIEWS", "97 MIN"),
            Movie(R.drawable.black_widow, "13+", false, "Action, Adventure, Sci-Fi",
                "4", "Black Widow", "38 REVIEWS", "102 MIN"),
            Movie(R.drawable.wonder_woman, "13+", false, "Action, Adventure, Fantasy",
                "5", "Wonder Woman 1984", "74 REVIEWS", "120 MIN")
        )
    }
}