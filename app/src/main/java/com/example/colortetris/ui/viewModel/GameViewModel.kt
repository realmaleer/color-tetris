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
    val displayedTime = logic.usedTime.map { convertDisplayedTime(it) }
    var isShowResult = logic.isGameEnd.map { it }
    val countDownStyle = logic.cdTime.map {
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
            logic.triggerCD()
        }
    }

    private fun convertDisplayedTime(usedTime: Int): String {
        val diffMin = usedTime / 60
        val diffSec = usedTime - diffMin * 60
        return if (diffSec < 10) {
            if (diffMin < 10) {
                "0$diffMin:0$diffSec"
            } else {
                "$diffMin:0$diffSec"
            }
        } else {
            if (diffMin < 10) {
                "0$diffMin:$diffSec"
            } else {
                "$diffMin:$diffSec"
            }
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