package `in`.squrlabs.local.entity

import `in`.squrlabs.domain.model.MovieModel
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(

    @ColumnInfo(name = "poster_path")
    val posterPath: String,

    @ColumnInfo(name = "adult")
    val adult: Boolean,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "original_title")
    val originalTitle: String,

    @ColumnInfo(name = "original_language")
    val originalLanguage: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,

    @ColumnInfo(name = "popularity")
    val popularity:Float,

    @ColumnInfo(name = "vote_count")
    val voteCount:Int,

    @ColumnInfo(name = "video")
    val video:Boolean,

    @ColumnInfo(name = "vote_average")
    val voteAverage: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0 ) {

    fun from(movieModel: MovieModel) = MovieEntity(
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

    fun to() = MovieModel(
        posterPath = posterPath,
        adult = adult,
        overview = overview,
        releaseDate = releaseDate,
        originalTitle = originalTitle,
        originalLanguage = originalLanguage,
        title = title,
        backdropPath = backdropPath,
        popularity = popularity,
        voteCount = voteCount,
        video = video,
        voteAverage = voteAverage,
        id = id
    )

}