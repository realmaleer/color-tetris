package com.example.colortetris.logic

import com.example.colortetris.model.TetrisBrick
import com.example.colortetris.repository.GameStateRepo
import kotlinx.coroutines.delay

class GameStateLogic(private val repo: GameStateRepo) {
    val isGameEnd = repo.isGameEnd
    val isGameStart = repo.isGameStart
    val usedTime = repo.usedTime
    val cdTime = repo.cdTime
    val isBrickUsed = repo.isBrickUsed
    val nextBrick = repo.nextBrick

    suspend fun updateGameEndStatus(status: Boolean) {
        repo.putGameEndStatus(status)
    }

    suspend fun updateGameStartStatus(status: Boolean) {
        repo.putGameStartStatus(status)
    }

    private suspend fun addUsedTime() {
        if (isGameStart.value) {
            repo.putUsedTime(usedTime.value + 1)
        }
    }

    suspend fun triggerTimer() {
        while (true) {
            delay(1000)
            addUsedTime()
        }
    }

    suspend fun generateBrick() {
        val shape = repo.getRandomTetrisBrickShape()
        val rotation = repo.getRandomBrickRotation()
        val color = repo.getRandomTetrisBlocksColor()
        val randomTetrisBrick = TetrisBrick(shape, rotation, color)
        repo.putRandomBrick(randomTetrisBrick)
        updateBrickUsedStatus(false)
    }

    private suspend fun updateBrickUsedStatus(isBrickUsed: Boolean) {
        repo.putBrickUsedStatus(isBrickUsed)
    }

    suspend fun triggerCD() {
        while (cdTime.value < 4) {
            delay(1000)
            repo.putCDTime(cdTime.value + 1)
        }
        delay(1000)
        repo.putCDTime(cdTime.value + 1)
        repo.putGameStartStatus(true)
    }
}