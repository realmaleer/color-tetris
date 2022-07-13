package com.example.colortetris.di

import com.example.colortetris.repository.GameStateRepo
import com.example.colortetris.repository.HighScoreRepo
import org.koin.dsl.module

val repositoryModule = module {
    single { GameStateRepo() }
    single { HighScoreRepo() }
}