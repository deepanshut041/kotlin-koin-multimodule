package `in`.squrlabs.detail

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailModule = module {
    viewModel { DetailViewModel(movieRepository = get()) }
}
