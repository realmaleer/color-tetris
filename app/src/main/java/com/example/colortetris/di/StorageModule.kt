package com.example.colortetris.di

import com.example.colortetris.storage.HighScoreStorage
import com.example.colortetris.storage.HighScoreStorageImpl
import org.koin.dsl.module

val storageModule = module {
    single<HighScoreStorage> { params ->
        HighScoreStorageImpl(storageName = params.get())
    }
}