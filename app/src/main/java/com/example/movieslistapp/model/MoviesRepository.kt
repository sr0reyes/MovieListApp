package com.example.movieslistapp.model

import androidx.lifecycle.LiveData
import com.example.movieslistapp.model.network.ApiMicroService
import com.example.movieslistapp.model.network.MovieListResponse
import com.example.movieslistapp.model.database.MoviesDao
import com.example.movieslistapp.model.entities.Movie
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val microService: ApiMicroService
)
{
    @Inject
    lateinit var mMoviesDao: MoviesDao

    suspend fun downloadMovies(api_key: String): MovieListResponse {
        return microService.GetData(api_key)
    }

    fun getMovies(filter: Float): LiveData<List<Movie>> {
        return mMoviesDao.getMovies(filter)
    }

    suspend fun syncData(values: List<Movie>) {
        mMoviesDao.insertAll(values)
    }
}