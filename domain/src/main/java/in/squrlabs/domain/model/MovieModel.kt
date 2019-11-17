package `in`.squrlabs.domain.model

data class MovieModel(
    val posterPath: String,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String,
    val originalTitle: String,
    val originalLanguage: String,
    val title: String,
    val backdropPath: String,
    val popularity:Float,
    val voteCount:Int,
    val video:Boolean,
    val voteAverage: String,
    val id:Int)