package com.example.movieslistapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.movieslistapp.model.entities.Movie
import com.example.movieslistapp.adapters.MovieListAdapter
import com.example.movieslistapp.databinding.FragmentMovieListBinding
import com.example.movieslistapp.viewmodel.MoviesListViewModel

class MovieListFragment : Fragment() {

    private lateinit var binding: FragmentMovieListBinding
    private val viewModel: MoviesListViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        setListeners()
    }

    private fun setObservers() {
        val adapter =MovieListAdapter(::onItemClick)
        binding.recyclerMovies.adapter = adapter
        viewModel.movieList.observe(viewLifecycleOwner) { list ->
            Log.d("TAG", "setObservers: " + list)
            adapter.submitList(list)
        }
    }

    private fun setListeners() {
        binding.apply {
            btnAll.setOnClickListener {
                viewModel.filter.postValue(0F)
            }
            btnTopRated.setOnClickListener {
                viewModel.filter.postValue(7.5F)
            }
        }
    }

    fun onItemClick(item: Movie) {
        Log.d("TAG", "setObservers: " + item.title)
        val action = MovieListFragmentDirections.actionMovieListToMovieDetail(item)
        findNavController().navigate(action)
    }

}