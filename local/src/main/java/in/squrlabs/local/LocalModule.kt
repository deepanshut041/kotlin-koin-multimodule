package `in`.squrlabs.local

import `in`.squrlabs.local.adapter.MovieLocalAdapter
import `in`.squrlabs.local.adapter.MovieLocalAdapterImpl
import org.koin.dsl.module

val localModule = module {

    single(createdAtStart = false) {
        get<AppDatabase>().getMovieDao()
    }

    single<MovieLocalAdapter>(createdAtStart = false) {
        MovieLocalAdapterImpl(get())
    }

}