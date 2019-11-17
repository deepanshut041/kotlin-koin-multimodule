package `in`.squrlabs.remote.dto

import `in`.squrlabs.domain.model.MovieModel
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
    val popularity: Float,

    @SerializedName("vote_count")
    val voteCount: Int,

    @SerializedName("video")
    val video: Boolean,

    @SerializedName("vote_average")
    val voteAverage: String,

    @SerializedName("id")
    val id: Int
)

object MovieDtoMapper {
    fun from(movieModel: MovieModel) = MovieDto(
        posterPath = movieModel.posterPath,
        adult = movieModel.adult,
        overview = movieModel.overview,
        releaseDate = movieModel.releaseDate,
        originalTitle = movieModel.originalTitle,
        originalLanguage = movieModel.originalLanguage,
        title = movieModel.title,
        backdropPath = movieModel.backdropPath,
        popularity = movieModel.popularity,
        voteCount = movieModel.voteCount,
        video = movieModel.video,
        voteAverage = movieModel.voteAverage,
        id = movieModel.id
    )

    fun to(movieDto: MovieDto) = MovieModel(
        posterPath = movieDto.posterPath,
        adult = movieDto.adult,
        overview = movieDto.overview,
        releaseDate = movieDto.releaseDate,
        originalTitle = movieDto.originalTitle,
        originalLanguage = movieDto.originalLanguage,
        title = movieDto.title,
        backdropPath = movieDto.backdropPath,
        popularity = movieDto.popularity,
        voteCount = movieDto.voteCount,
        video = movieDto.video,
        voteAverage = movieDto.voteAverage,
        id = movieDto.id
    )
}
