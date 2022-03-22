package com.example.movieslistapp.viewmodel

import androidx.lifecycle.*
import com.example.movieslistapp.model.entities.Movie
import com.example.movieslistapp.model.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository,
    @Named("api_key") private val api_key: String
) : ViewModel() {

    val filter: MutableLiveData<Float> = MutableLiveData(0F)

    // var movieList: LiveData<List<Movie>> = moviesRepository.mMoviesDao.getMovies()

    var movieList: LiveData<List<Movie>> = Transformations.switchMap(filter) {
        moviesRepository.getMovies(it)
    }

    private suspend fun downloadMovies() {
        moviesRepository.downloadMovies(api_key).let {
            moviesRepository.syncData(it.results)
        }
    }

    init {
        viewModelScope.launch {
            downloadMovies()
        }
    }
}