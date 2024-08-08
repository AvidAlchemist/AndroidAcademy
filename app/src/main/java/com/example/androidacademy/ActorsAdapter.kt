package com.example.androidacademy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidacademy.data.models.Actor

class ActorsAdapter() : RecyclerView.Adapter<ActorsViewHolder>() {
    private var actors = listOf<Actor>()

    override fun getItemViewType(position: Int): Int {
        return when(actors.size){
            0 -> VIEW_TYPE_EMPTY
            else -> VIEW_TYPE_ACTORS
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        return when(viewType)  {
            VIEW_TYPE_ACTORS -> ActorsDataViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_actor, parent, false))
            else -> ActorsEmptyViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_actor, parent, false))
        }
    }

    override fun getItemCount(): Int = actors.size

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        when(holder) {
            is ActorsDataViewHolder -> holder.onBind(actors[position])
            is ActorsEmptyViewHolder -> {}
        }
    }

    fun bindActors(newActors: List<Actor>) {
        actors = newActors
        notifyDataSetChanged()
    }
}

abstract class ActorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
private class ActorsEmptyViewHolder(itemView: View) : ActorsViewHolder(itemView)
private class ActorsDataViewHolder(itemView: View) : ActorsViewHolder(itemView) {
    val photo : ImageView = itemView.findViewById(R.id.actor_photo)
    val name : TextView = itemView.findViewById(R.id.actor_name)

    fun onBind(actor: Actor){
        Glide.with(context)
            .load(actor.photo)
            .apply(imageOption)
            .into(photo)

        name.text = actor.name
    }

    companion object{
        private val imageOption = RequestOptions()
            .placeholder(R.drawable.robert_downey_jr)
            .fallback(R.drawable.robert_downey_jr)
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

private const val VIEW_TYPE_EMPTY = 0
private const val VIEW_TYPE_ACTORS = 1