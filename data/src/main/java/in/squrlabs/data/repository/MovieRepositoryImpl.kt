package `in`.squrlabs.data.repository

import `in`.squrlabs.domain.model.MovieModel
import `in`.squrlabs.domain.repository.MovieRepository
import `in`.squrlabs.local.adapter.MovieLocalAdapter
import `in`.squrlabs.remote.adapter.MovieRemoteAdapter
import io.reactivex.Completable
import io.reactivex.Flowable

class MovieRepositoryImpl(
    private val remote: MovieRemoteAdapter,
    private val local: MovieLocalAdapter
) : MovieRepository {

    override fun getMovies(pageNo: Int): Completable {
        return remote.loadPopularMovies(pageNo)
            .flatMapCompletable {
                for (movieModel in it)
                    local.insertMovie(movieModel)
                Completable.complete()
            }
    }

    override fun loadMovies(): Flowable<List<MovieModel>> {
        return local.loadMovies()
    }

    override fun sync(): Completable {
        return getMovies(1)
            .andThen ( getMovies(2) )
            .andThen ( getMovies(3) )
            .andThen ( getMovies(4) )
            .andThen ( getMovies(5) )
    }
}