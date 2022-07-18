package com.example.colortetris.di

import com.example.colortetris.ui.viewModel.GameViewModel
import com.example.colortetris.ui.viewModel.HighScoreViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { HighScoreViewModel(get()) }
    single { GameViewModel(get()) }
}