package `in`.squrlabs.remote

import `in`.squrlabs.remote.adapter.MovieRemoteAdapter
import `in`.squrlabs.remote.adapter.MovieRemoteAdapterImpl
import `in`.squrlabs.remote.endpoint.MovieEndpoint
import org.koin.dsl.module
import retrofit2.Retrofit

val remoteModule = module {

    single(createdAtStart = false) {
        get<Retrofit>().create(MovieEndpoint::class.java)
    }

    single<MovieRemoteAdapter>(createdAtStart = false) {
        MovieRemoteAdapterImpl(get())
    }

}