package ru.barinov.studyapp

import android.app.Application
import org.koin.android.ext.koin.*
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import java.lang.Appendable

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApp)
            modules(listOf(appModule))
        }
    }
}