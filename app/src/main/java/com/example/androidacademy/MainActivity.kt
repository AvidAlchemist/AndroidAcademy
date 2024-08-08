package com.example.androidacademy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), FragmentMoviesList.ClickListener {
    private val moviesListFragment = FragmentMoviesList()
    private val moviesDetailsFragment = FragmentMoviesDetails()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.main_container, moviesListFragment)
                commit()
            }
        }
    }

    private fun moveToNextScreen() {
        val intent = Intent(this, MovieDetailsActivity::class.java)

        startActivity(intent)
    }

    override fun moveToNextFragment(name : String) {
        supportFragmentManager.beginTransaction().apply {
            addToBackStack(null)
            when(name){
                "Avengers: End Game" ->
                    replace(R.id.main_container, FragmentMoviesDetails.newInstance("13+",
                        "Avengers: End Game", "Action, Adventure, Fantasy", "4",
                        "125 REVIEWS", R.string.storyline))
                "Tenet" ->
                    replace(R.id.main_container, FragmentMoviesDetails.newInstance("13+",
                        "Tenet", "Action, Adventure, Fantasy", "4",
                        "125 REVIEWS", R.string.storyline))
                "Black Widow" ->
                    replace(R.id.main_container, FragmentMoviesDetails.newInstance("13+",
                        "Black Widow", "Action, Adventure, Fantasy", "4",
                        "125 REVIEWS", R.string.storyline))
                "Wonder Woman 1984" ->
                    replace(R.id.main_container, FragmentMoviesDetails.newInstance("13+",
                        "Wonder Woman 1984", "Action, Adventure, Fantasy", "4",
                        "125 REVIEWS", R.string.storyline))
            }

            commit()
        }
    }

    override fun moveToMoviesList() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_container, FragmentMoviesList.newInstance("academy"))
            commit()
        }
    }


}