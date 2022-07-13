package com.example.colortetris.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colortetris.logic.GameStateLogic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

data class CountDownViewStyling(
    val countDownString: String,
    val countDownHeight: Int,
)

class GameViewModel(
    private val logic: GameStateLogic,
) : ViewModel() {
    var isShowResult = logic.isGameEnd.map { it }
    val countDownStyle = logic.usedTime.map {
        when (it) {
            0 -> {
                CountDownViewStyling("", 100)
            }
            1 -> {
                CountDownViewStyling("3", 100)
            }
            2 -> {
                CountDownViewStyling("2", 100)
            }
            3 -> {
                CountDownViewStyling("1", 100)
            }
            4 -> {
                CountDownViewStyling("Start!", 100)
            }
            else -> {
                CountDownViewStyling("", 0)
            }
        }
    }

    fun enterGameScreenAction() {
        viewModelScope.launch(Dispatchers.Main) {
            logic.updateGameStartStatus(true)
        }
    }

    // Timer
    init {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                delay(1000L)
                logic.addUsedTime()
            }
        }
    }

}