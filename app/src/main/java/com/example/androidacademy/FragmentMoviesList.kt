package com.example.androidacademy

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidacademy.data.models.Movie
import com.example.androidacademy.domain.MoviesDataSource

class FragmentMoviesList : Fragment() {
    private var viewClick : View? = null
    private var fragmentClickListener : ClickListener? = null
    private var recycler : RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler = view.findViewById(R.id.rv_movies)
        recycler?.adapter = MoviesAdapter(clickListener)
        recycler?.setLayoutManager(GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false))
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ClickListener)
            fragmentClickListener = context
    }

    override fun onDetach() {
        recycler = null
        fragmentClickListener = null
        super.onDetach()
    }

    private fun updateData() {
        (recycler?.adapter as? MoviesAdapter)?.apply {
            bindMovies(MoviesDataSource().getMovies())
        }
    }

    private fun doOnClick(movie : Movie) {
        fragmentClickListener?.moveToNextFragment()
    }

    private val clickListener = object : OnRecyclerItemClicked{
        override fun onClick(movie: Movie) {
            doOnClick(movie)
        }
    }

    companion object {
        fun newInstance(academy : String) : FragmentMoviesList {
            val args = Bundle()
            args.putString("android", academy)
            val fragment = FragmentMoviesList()
            fragment.arguments = args
            return fragment
        }
    }

    interface ClickListener {
        fun moveToNextFragment()
        fun moveToMoviesList()
    }
}