package com.example.colortetris.ui.viewModel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colortetris.logic.GameStateLogic
import com.example.colortetris.model.TetrisBrickShape
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
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
    val playAreaColor = logic.playAreaColor
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

    private val brickUsedAction = logic.isBrickUsed
        .onEach {
            if (it) {
                logic.generateBrick()
            }
        }
        .flowOn(Dispatchers.IO)

    val displayNextBrick = logic.nextBrick
        .map {
            when (it?.shape) {
                TetrisBrickShape.I -> {
                    arrayOf(Array(4) { _ -> it.color }, Array(4) { Color.Black })
                }

                TetrisBrickShape.J -> {
                    arrayOf(
                        arrayOf(Color.Black, it.color, Color.Black, Color.Black),
                        arrayOf(Color.Black, it.color, it.color, it.color)
                    )
                }

                TetrisBrickShape.L -> {
                    arrayOf(
                        arrayOf(Color.Black, it.color, it.color, it.color),
                        arrayOf(Color.Black, it.color, Color.Black, Color.Black)
                    )
                }

                TetrisBrickShape.O -> {
                    arrayOf(
                        arrayOf(Color.Black, Color.Black, it.color, it.color),
                        arrayOf(Color.Black, it.color, it.color, Color.Black)
                    )
                }

                TetrisBrickShape.S -> {
                    arrayOf(
                        arrayOf(Color.Black, it.color, it.color, Color.Black),
                        arrayOf(Color.Black, it.color, it.color, Color.Black)
                    )
                }

                TetrisBrickShape.T -> {
                    arrayOf(
                        arrayOf(Color.Black, it.color, it.color, it.color),
                        arrayOf(Color.Black, Color.Black, it.color, Color.Black)
                    )
                }

                TetrisBrickShape.Z -> {
                    arrayOf(
                        arrayOf(Color.Black, it.color, it.color, Color.Black),
                        arrayOf(Color.Black, Color.Black, it.color, it.color)
                    )
                }

                else -> {
                    arrayOf(Array(4) { Color.Black }, Array(4) { Color.Black })
                }
            }

        }
        .flowOn(Dispatchers.IO)

    val displayCurrentBrick = logic.currentBrick
        .map {

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
        viewModelScope.launch(Dispatchers.IO) {
            brickUsedAction.collect()
            displayNextBrick.collect()
        }
    }
}