package com.example.movieslistapp.model.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Movie(
    @PrimaryKey val id: Int,
    var poster_path: String?,
    var adult: Boolean,
    var overview: String,
    var release_date: String,
    var original_title: Boolean,
    // var genre_ids: List<Int>, add TypeConverter to handle this value with room
    var media_type: String,
    var original_language: String,
    var title: String,
    var backdrop_path: String?,
    var popularity: Float,
    var vote_count: Int,
    var video: Boolean,
    var vote_average: Float,
): Parcelable