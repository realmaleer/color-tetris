package com.example.colortetris.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.colortetris.logic.GameStateLogic
import kotlinx.coroutines.flow.map

class GameViewModel(
    private val logic: GameStateLogic,
) : ViewModel() {
    var isShowResult = logic.isGameEnd.map {it}
}