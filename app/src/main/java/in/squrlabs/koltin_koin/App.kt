package `in`.squrlabs.koltin_koin

import `in`.squrlabs.data.*
import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(
                networkModule, databaseModule,  localModule, remoteModule, repositoryModule
            ))


            Fresco.initialize(this@App)
        }
    }
}