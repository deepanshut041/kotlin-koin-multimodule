package `in`.squrlabs.local

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val databaseModule = module {

    single { AppDatabase.getInstance(androidApplication()) }
}