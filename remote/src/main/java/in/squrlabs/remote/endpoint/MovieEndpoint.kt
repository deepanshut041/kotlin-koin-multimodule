package `in`.squrlabs.remote.endpoint

import `in`.squrlabs.remote.dto.MovieDto
import `in`.squrlabs.remote.dto.PopularMovieDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieEndpoint {
    @GET("3/discover/movie")
    fun loadPopularMovies(@Query("page") page: Int): Single<PopularMovieDto>

    @GET("3/movie/{id}")
    fun loadMovie(@Path("id") id: Long): Single<MovieDto>
}