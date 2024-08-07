package com.example.androidacademy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.androidacademy.data.models.Movie
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MoviesAdapter(
    private val clickListener : OnRecyclerItemClicked
) : RecyclerView.Adapter<MoviesViewHolder>() {

    private var movies = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
       return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false))
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        if(holder is DataViewHolder){
            holder.onBind(movies[position])
            holder.itemView.setOnClickListener{
                clickListener.onClick(movies[position])
            }
        }
    }

    fun bindMovies(newMovies : List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }
}

abstract class MoviesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

private class EmptyViewHolder(itemView: View) : MoviesViewHolder(itemView)
private class DataViewHolder(itemView: View) : MoviesViewHolder(itemView) {
    private val image : ImageView = itemView.findViewById(R.id.movies_list_image)
    private val age : TextView = itemView.findViewById(R.id.movies_list_pg)
    private val likeState : ImageView = itemView.findViewById(R.id.movies_list_like)
    private val tags : TextView = itemView.findViewById(R.id.movies_list_tags)
    private val rating : RatingBar = itemView.findViewById(R.id.movies_list_rating)
    private val name : TextView = itemView.findViewById(R.id.movies_list_name)
    private val reviews : TextView = itemView.findViewById(R.id.movies_list_reviews)
    private val mins : TextView = itemView.findViewById(R.id.movies_list_min)

    fun onBind(movie: Movie) {
        Glide.with(context)
            .load(movie.image)
            .apply(imageOption)
            .into(image)

        age.text = movie.age
        if (movie.hasLike) {
            Glide.with(context)
                .load(R.drawable.red_like)
                .apply(imageOption)
                .into(likeState)
        }
        else{
            Glide.with(context)
                .load(R.drawable.like)
                .apply(imageOption)
                .into(likeState)
        }
        tags.text = movie.tags
        rating.rating = movie.rating.toFloat()
        name.text = movie.name
        reviews.text = movie.reviews
        mins.text = movie.mins
    }

    companion object {
        private val imageOption = RequestOptions()
            .placeholder(R.drawable.avengers)
            .fallback(R.drawable.avengers)
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

interface OnRecyclerItemClicked {
    fun onClick(movie: Movie)
}
