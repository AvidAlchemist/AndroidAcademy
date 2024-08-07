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

    override fun moveToNextFragment() {
        supportFragmentManager.beginTransaction().apply {
            addToBackStack(null)
            replace(R.id.main_container, moviesDetailsFragment)
            commit()
        }
    }

    override fun moveToMoviesList() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_container, moviesListFragment)
            commit()
        }
    }


}