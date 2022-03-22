package com.example.movieslistapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieslistapp.model.entities.Movie
import com.example.movieslistapp.databinding.ItemMovieBinding

class MovieListAdapter( private val onSeeDetail: (Movie) -> Unit) : ListAdapter<Movie, MovieListAdapter.MovieViewHolder>(Companion) {

    class MovieViewHolder(
        val binding: ItemMovieBinding
    ): RecyclerView.ViewHolder(binding.root) {

    }

    companion  object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currenItem = getItem(position)
        holder.binding.apply {
            tvMovieTitle.text = currenItem.title
            tvMovieDate.text = currenItem.release_date
            root.setOnClickListener {
                onSeeDetail(currenItem)
            }
        }
    }
}