package com.example.movieslistapp.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieslistapp.model.entities.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}