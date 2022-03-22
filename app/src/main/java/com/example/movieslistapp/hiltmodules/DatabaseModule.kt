package com.example.movieslistapp.hiltmodules

import android.content.Context
import androidx.room.Room
import com.example.movieslistapp.model.database.AppRoomDatabase
import com.example.movieslistapp.model.database.MoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideMoviesDao(appDatabase: AppRoomDatabase): MoviesDao {
        return appDatabase.moviesDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase (@ApplicationContext appContext: Context): AppRoomDatabase {
        return Room.databaseBuilder (
            appContext,
            AppRoomDatabase::class.java,
            "movieDatabase"
        ).fallbackToDestructiveMigration().build ()
    }
}