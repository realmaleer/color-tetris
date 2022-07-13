package com.example.colortetris.di

import com.example.colortetris.logic.GameStateLogic
import org.koin.dsl.module

val logicModule = module {
    single { GameStateLogic(get()) }
}