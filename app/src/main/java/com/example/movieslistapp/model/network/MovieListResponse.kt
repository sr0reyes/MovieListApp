package com.example.movieslistapp.model.network

import com.example.movieslistapp.model.entities.Movie

data class MovieListResponse(
    var poster_path: String?,
    var id: Int,
    var backdrop_path: String?,
    var total_results: Int,
    var public: Boolean,
    var revenue: String,
    var page: Int,
    var results: List<Movie>,
    var iso_639_1: String,
    var total_pages: Int,
    var description: String,
    var created_by: Any,
    var iso_3166_1: String,
    var average_rating: Number,
    var runtime: Int,
    var name: String,
    var comments: Any
)