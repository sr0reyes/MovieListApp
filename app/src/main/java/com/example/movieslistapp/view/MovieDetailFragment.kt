package com.example.movieslistapp.view

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movieslistapp.R
import com.example.movieslistapp.databinding.FragmentMovieDetailBinding


class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding
    private val args: MovieDetailFragmentArgs by navArgs()

    private lateinit var movieTitle: String
    private lateinit var releaseDate: String
    private lateinit var voteAverage: Number
    private lateinit var description: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args.selectedMovie.let {
            movieTitle = it.title
            releaseDate = it.release_date
            voteAverage = it.vote_average
            description = it.overview
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            tvTitle.text = movieTitle
            tvMovieTitle.text = movieTitle
            tvReleaseDate.text = releaseDate
            tvRateValue.text = voteAverage.toString()
            tvOverviewValue.text = description
            binding.btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
            videoView.setVideoURI(Uri.parse("android.resource://"+activity?.packageName+"/"+R.raw.videoplayback))
            videoView.start()
        }
    }


}