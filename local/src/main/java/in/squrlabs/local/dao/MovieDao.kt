package `in`.squrlabs.local.dao

import `in`.squrlabs.local.entity.MovieEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun findAll(): Flowable<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieEntity)
}