package com.example.colortetris.logic

import com.example.colortetris.repository.GameStateRepo

class GameStateLogic(private val repo: GameStateRepo) {
    val isGameEnd = repo.isGameEnd

    suspend fun updateGameEndStatus(status: Boolean) {
        repo.updateGameEndStatus(status)
    }
}