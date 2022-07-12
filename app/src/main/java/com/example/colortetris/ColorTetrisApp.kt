package com.example.colortetris

import android.app.Application
import com.example.colortetris.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ColorTetrisApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ColorTetrisApp)
            modules(listOf(repositoryModule))
        }
    }
}