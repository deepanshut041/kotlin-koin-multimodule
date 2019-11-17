package `in`.squrlabs.local.adapter

import `in`.squrlabs.domain.model.MovieModel
import `in`.squrlabs.local.dao.MovieDao
import `in`.squrlabs.local.entity.MovieEntityMapper
import io.reactivex.Flowable
import io.reactivex.Maybe

class MovieLocalAdapterImpl(private val movieDao: MovieDao) : MovieLocalAdapter {
    override fun loadMovie(id: Long): Maybe<MovieModel> {
        return movieDao.findById(id).map(MovieEntityMapper::to)
    }

    override fun insertMovie(movieModel: MovieModel) {
        movieDao.insert(MovieEntityMapper.from(movieModel))
    }

    override fun loadMovies(): Flowable<List<MovieModel>> {
        return movieDao.findAll().map { list ->
            list.map(MovieEntityMapper::to)
        }
    }

}

interface MovieLocalAdapter {
    fun insertMovie(movieModel: MovieModel)
    fun loadMovies(): Flowable<List<MovieModel>>
    fun loadMovie(id: Long): Maybe<MovieModel>
}