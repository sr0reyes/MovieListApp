package com.example.movieslistapp.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieslistapp.model.entities.Movie

@Dao
interface MoviesDao {

    @Query("SELECT * FROM Movie WHERE vote_average >= :filter")
    abstract fun getMovies(filter: Float): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAll(movieList: List<Movie>)
}