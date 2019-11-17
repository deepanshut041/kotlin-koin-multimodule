package `in`.squrlabs.local

import `in`.squrlabs.local.AppDatabase.Companion.DB_VERSION
import `in`.squrlabs.local.dao.MovieDao
import `in`.squrlabs.local.entity.MovieEntity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [MovieEntity::class], version = DB_VERSION, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getMovieDao(): MovieDao

    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "mvvm_demo.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_TO_2)
                .build()

        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
    }
}