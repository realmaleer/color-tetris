package com.example.colortetris.repository

import com.example.colortetris.model.BrickRotation
import com.example.colortetris.model.TetrisBlocksColor
import com.example.colortetris.model.TetrisBrick
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.*

class GameStateRepo {
    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score

    private val _speedLevel = MutableStateFlow(1)
    val speedLevel: StateFlow<Int> = _speedLevel

    private val _blocksNumber = MutableStateFlow(0)
    val blocksNumber: StateFlow<Int> = _blocksNumber

    private val _usedTime = MutableStateFlow(0)
    val usedTime: StateFlow<Int> = _usedTime

    private val _playAreaState = MutableStateFlow(Array(24) {
        Array(12) { TetrisBlocksColor.Black }
    })
    val playAreaState: StateFlow<Array<Array<TetrisBlocksColor>>> = _playAreaState

    private val _isGameEnd = MutableStateFlow(false)
    val isGameEnd: StateFlow<Boolean> = _isGameEnd

    private val _isGameStart = MutableStateFlow(false)
    val isGameStart: StateFlow<Boolean> = _isGameStart

    private val _isBrickUsed = MutableStateFlow(false)
    val isBrickUsed: StateFlow<Boolean> = _isBrickUsed

    private val _currentBrick = MutableStateFlow<TetrisBrick?>(null)
    val currentBrick: StateFlow<TetrisBrick?> = _currentBrick

    private val _nextBrick = MutableStateFlow<TetrisBrick?>(null)
    val nextBrick: StateFlow<TetrisBrick?> = _nextBrick

    private val _maxHeight = MutableStateFlow(0)
    val maxHeight: StateFlow<Int> = _maxHeight

    suspend fun putGameEndStatus(isGameEnd: Boolean) {
        _isGameEnd.emit(isGameEnd)
    }

    suspend fun putGameStartStatus(isGameStart: Boolean) {
        _isGameStart.emit(isGameStart)
    }

    fun getRandomTetrisBrick(): TetrisBrick {
        val brickList = listOf(
            TetrisBrick.I,
            TetrisBrick.J,
            TetrisBrick.L,
            TetrisBrick.O,
            TetrisBrick.S,
            TetrisBrick.T,
            TetrisBrick.Z,
        )
        val randomIndex = Random().nextInt(7)
        return brickList[randomIndex]
    }

    fun getRandomBrickRotation(): BrickRotation {
        val rotationList = listOf(
            BrickRotation.Original,
            BrickRotation.Quarter,
            BrickRotation.Half,
            BrickRotation.ThreeQuarter,
        )
        val randomIndex = Random().nextInt(4)
        return rotationList[randomIndex]
    }

    fun getRandomTetrisBlocksColor(): TetrisBlocksColor {
        val colorList = listOf(
            TetrisBlocksColor.Yellow,
            TetrisBlocksColor.Red,
            TetrisBlocksColor.Green,
            TetrisBlocksColor.Blue,
            TetrisBlocksColor.White,
            TetrisBlocksColor.Pink,
        )
        val randomIndex = Random().nextInt(6)
        return colorList[randomIndex]
    }

    suspend fun putUsedTime(newUsedTime: Int) {
        _usedTime.emit(newUsedTime)
    }
}