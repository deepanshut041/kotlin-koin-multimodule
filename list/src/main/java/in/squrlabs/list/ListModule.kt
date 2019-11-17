package `in`.squrlabs.list

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val listModule = module {
    viewModel {
        ListViewModel(get())
    }
}