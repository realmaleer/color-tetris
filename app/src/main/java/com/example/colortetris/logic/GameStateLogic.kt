package com.example.colortetris.logic

import com.example.colortetris.repository.GameStateRepo

class GameStateLogic(private val repo: GameStateRepo) {
    val isGameEnd = repo.isGameEnd
    val isGameStart = repo.isGameStart
    val usedTime = repo.usedTime

    suspend fun updateGameEndStatus(status: Boolean) {
        repo.putGameEndStatus(status)
    }

    suspend fun updateGameStartStatus(status: Boolean) {
        repo.putGameStartStatus(status)
    }

    suspend fun addUsedTime() {
        if (isGameStart.value) {
            repo.putUsedTime(usedTime.value + 1)
        }
    }
}