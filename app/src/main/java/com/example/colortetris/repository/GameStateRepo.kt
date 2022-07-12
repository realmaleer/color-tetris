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

    val initState = Array(24) { Array(12) { TetrisBlocksColor.Black } }

    private val _playAreaState = MutableStateFlow(Array(24) {
        Array(12) { TetrisBlocksColor.Black }
    })
    val playAreaState: StateFlow<Array<Array<TetrisBlocksColor>>> = _playAreaState
}