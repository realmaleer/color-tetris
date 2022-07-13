package com.example.colortetris.di

import com.example.colortetris.ui.viewModel.HighScoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HighScoreViewModel(get()) }
}