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

        /*val textView = findViewById<TextView>(R.id.just_test)
        textView.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.main_container,moviesDetailsFragment)
                addToBackStack(null)
                commit()
            }
        }*/

        supportFragmentManager.beginTransaction().apply {
            add(R.id.main_container,FragmentMoviesList.newInstance("academy"))
            commit()
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


}