package com.example.colortetris.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameStateRepo {
    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score

    private val _speedLevel = MutableStateFlow(1)
    val speedLevel: StateFlow<Int> = _speedLevel

    private val _blocksNumber = MutableStateFlow(0)
    val blacksNumber: StateFlow<Int> = _blocksNumber
}