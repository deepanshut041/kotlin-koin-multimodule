package `in`.squrlabs.domain.repository

import `in`.squrlabs.domain.model.MovieModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe

interface MovieRepository {

    fun getMovies(pageNo: Int = 1): Completable
    fun loadMovies(): Flowable<List<MovieModel>>
    fun sync(): Completable
    fun getMovie(id: Long): Maybe<MovieModel>
}