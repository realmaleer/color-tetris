package com.example.colortetris.repository

import androidx.compose.ui.graphics.Color.Companion.Black
import com.example.colortetris.model.BrickRotation
import com.example.colortetris.model.TetrisBlocksColor
import com.example.colortetris.model.TetrisBrick
import com.example.colortetris.model.TetrisBrickShape
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

    private val _cdTime = MutableStateFlow(0)
    val cdTime: StateFlow<Int> = _cdTime

    private val _playAreaState = MutableStateFlow(Array(24) {
        Array(12) { Black }
    })
    val playAreaState: StateFlow<Array<Array<androidx.compose.ui.graphics.Color>>> = _playAreaState

    private val _nextAreaState = MutableStateFlow(Array(2) {
        Array(4) { Black }
    })
    val nextAreaState: StateFlow<Array<Array<androidx.compose.ui.graphics.Color>>> = _nextAreaState

    private val _isGameEnd = MutableStateFlow(false)
    val isGameEnd: StateFlow<Boolean> = _isGameEnd

    private val _isGameStart = MutableStateFlow(false)
    val isGameStart: StateFlow<Boolean> = _isGameStart

    private val _isBrickUsed = MutableStateFlow(true)
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

    fun getRandomTetrisBrickShape(): TetrisBrickShape {
        val randomIndex = Random().nextInt(7)
        return TetrisBrickShape.values()[randomIndex]
    }

    fun getRandomBrickRotation(): BrickRotation {
        val randomIndex = Random().nextInt(4)
        return BrickRotation.values()[randomIndex]
    }

    fun getRandomTetrisBlocksColor(): androidx.compose.ui.graphics.Color {
        val randomIndex = Random().nextInt(6) + 1
        return TetrisBlocksColor[randomIndex]
    }

    fun getRandomStartPosition(): Int {
        return Random().nextInt(12)
    }

    suspend fun putUsedTime(newUsedTime: Int) {
        _usedTime.emit(newUsedTime)
    }

    suspend fun putCDTime(newCDTime: Int) {
        _cdTime.emit(newCDTime)
    }

    suspend fun putBrickUsedStatus(isBrickUsed: Boolean) {
        _isBrickUsed.emit(isBrickUsed)
    }

    suspend fun putRandomBrick(tetrisBrick: TetrisBrick) {
        _currentBrick.emit(_nextBrick.value)
        _nextBrick.emit(tetrisBrick)
    }
}