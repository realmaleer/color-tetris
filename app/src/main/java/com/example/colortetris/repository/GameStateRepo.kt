package com.example.colortetris.repository

import com.example.colortetris.model.TetrisBlocksColor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameStateRepo {
    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score

    private val _speedLevel = MutableStateFlow(1)
    val speedLevel: StateFlow<Int> = _speedLevel

    private val _blocksNumber = MutableStateFlow(0)
    val blacksNumber: StateFlow<Int> = _blocksNumber

    private val _usedTime = MutableStateFlow(0)
    val usedTime: StateFlow<Int> = _usedTime

    private val _playAreaState = MutableStateFlow(Array(24) {
        Array(12) { TetrisBlocksColor.Black }
    })
    val playAreaState: StateFlow<Array<Array<TetrisBlocksColor>>> = _playAreaState

    private val _isGameEnd = MutableStateFlow(false)
    val isGameEnd: StateFlow<Boolean> = _isGameEnd

    suspend fun updateGameEndStatus(isGameEnd: Boolean) {
        _isGameEnd.emit(isGameEnd)
    }
}