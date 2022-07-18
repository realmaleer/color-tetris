package com.example.colortetris.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colortetris.logic.GameStateLogic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

data class CountDownViewStyling(
    val countDownString: String,
    val countDownHeight: Int,
)

class GameViewModel(
    private val logic: GameStateLogic,
) : ViewModel() {
    val isGameEnd = logic.isGameEnd
    val isGameStart = logic.isGameStart
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
        viewModelScope.launch(Dispatchers.IO) {
            logic.updateGameStartStatus(true)
        }
    }

    private fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            logic.triggerTimer()
        }
    }

    // Timer
    init {
        init()
    }
}