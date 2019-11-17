package `in`.squrlabs.local.dao

import `in`.squrlabs.local.entity.MovieEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun findAll(): Flowable<List<MovieEntity>>

    @Query("SELECT * FROM movies WHERE id = :id")
    fun findById(id:Long): Maybe<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieEntity)
}