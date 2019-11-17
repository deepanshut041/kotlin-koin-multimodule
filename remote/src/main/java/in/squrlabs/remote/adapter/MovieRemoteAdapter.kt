package `in`.squrlabs.remote.adapter

import `in`.squrlabs.domain.model.MovieModel
import `in`.squrlabs.remote.dto.MovieDtoMapper
import `in`.squrlabs.remote.endpoint.MovieEndpoint
import io.reactivex.Single

class MovieRemoteAdapterImpl(
    private val movieEndpoint: MovieEndpoint
) : MovieRemoteAdapter {
    override fun loadPopularMovies(page: Int): Single<List<MovieModel>> {
        return movieEndpoint.loadPopularMovies(page).map {
            it.popularMovies.map(MovieDtoMapper::to)
        }
    }

    override fun loadMovie(id: Long): Single<MovieModel> {
        return movieEndpoint.loadMovie(id).map(MovieDtoMapper::to)
    }

}

interface MovieRemoteAdapter {
    fun loadPopularMovies(page: Int): Single<List<MovieModel>>

    fun loadMovie(id: Long): Single<MovieModel>
}