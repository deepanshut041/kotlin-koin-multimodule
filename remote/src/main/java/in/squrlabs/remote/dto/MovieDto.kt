package `in`.squrlabs.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("adult")
    val adult: Boolean,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("original_title")
    val originalTitle: String,

    @SerializedName("original_language")
    val originalLanguage: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("backdrop_path")
    val backdropPath: String,

    @SerializedName("popularity")
    val popularity:Float,

    @SerializedName("vote_count")
    val voteCount:Int,

    @SerializedName("video")
    val video:Boolean,

    @SerializedName("vote_average")
    val voteAverage: String,

    @SerializedName("id")
    val id: Int
)
