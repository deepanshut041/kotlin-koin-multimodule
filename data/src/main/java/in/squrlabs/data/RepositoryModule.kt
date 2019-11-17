package `in`.squrlabs.data

import `in`.squrlabs.data.repository.MovieRepositoryImpl
import `in`.squrlabs.domain.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository>(createdAtStart = false) {
        MovieRepositoryImpl(get(), get())
    }
}

val databaseModule = `in`.squrlabs.local.databaseModule
val localModule = `in`.squrlabs.local.localModule
val networkModule = `in`.squrlabs.remote.networkModule
val remoteModule = `in`.squrlabs.remote.remoteModule
