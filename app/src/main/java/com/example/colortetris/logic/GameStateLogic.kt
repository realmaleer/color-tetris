package com.example.colortetris.logic

import androidx.compose.ui.graphics.Color
import com.example.colortetris.model.BrickRotation
import com.example.colortetris.model.TetrisBrick
import com.example.colortetris.model.TetrisBrickShape
import com.example.colortetris.repository.GameStateRepo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach

class GameStateLogic(private val repo: GameStateRepo) {
    val isGameEnd = repo.isGameEnd
    val isGameStart = repo.isGameStart
    val usedTime = repo.usedTime
    val cdTime = repo.cdTime
    val isBrickUsed = repo.isBrickUsed
    val nextBrick = repo.nextBrick
    val playAreaColor = repo.playAreaColor
    val fixedColor = repo.fixedColor
    private val tetrisBrickCurrentPosition = repo.tetrisBrickCurrentPosition

    val currentBrick = repo.currentBrick.onEach {
        if (it != null) {
            startNewBrick(it)
        }
    }

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
        repo.putBrickUsedStatus(false)
    }

    suspend fun triggerCD() {
        while (cdTime.value <= 4) {
            delay(1000)
            repo.putCDTime(cdTime.value + 1)
        }
        repo.putGameStartStatus(true)
        generateBrick()
        generateBrick()
    }

    private suspend fun startNewBrick(tetrisBrick: TetrisBrick) {
        val blockStartPosition = calculatePosition(tetrisBrick.shape, tetrisBrick.rotation)
        val brickModel = generateBrickModel(tetrisBrick.shape, tetrisBrick.rotation)
        val brickVerticalPosition = 4 - brickModel.size
        val newBrickCurrentPosition = tetrisBrickCurrentPosition.value

        for (i in brickModel.indices) {
            val brickRow = brickModel[brickModel.size - i - 1]
            for (j in 0 until brickModel[0].size) {
                if (brickRow[j]) {
                    newBrickCurrentPosition[0][0] = brickVerticalPosition + i
                    newBrickCurrentPosition[0][1] = blockStartPosition + j
                }
            }
        }

        while (true) {
            downMovement()
            delay(1000)
        }
    }

    private suspend fun downMovement() {
        val newBrickCurrentPosition = tetrisBrickCurrentPosition.value
        for (i in 0..3) {
            newBrickCurrentPosition[i][0] = tetrisBrickCurrentPosition.value[i][0]?.plus(1)
            if (fixedColor.value[newBrickCurrentPosition[i][0]!!][newBrickCurrentPosition[i][1]!!] != Color.Black
                || newBrickCurrentPosition[i][0]!! > 27
            ) {
                repo.putTetrisBrickCurrentPosition(Array(4) { Array(2) { null } })
                repo.putFixedColor(playAreaColor.value)
                repo.putBrickUsedStatus(true)
                break
            }
            if (i == 3) {
                repo.putTetrisBrickCurrentPosition(newBrickCurrentPosition)
            }
        }
    }

    private fun generateBrickModel(
        shape: TetrisBrickShape,
        rotation: BrickRotation
    ): Array<Array<Boolean>> {
        when (shape) {
            TetrisBrickShape.O -> {
                return arrayOf(arrayOf(true, true), arrayOf(true, true))
            }

            TetrisBrickShape.I -> {
                return when (rotation) {
                    BrickRotation.Original, BrickRotation.Half -> {
                        arrayOf(arrayOf(true, true, true, true))
                    }
                    BrickRotation.Quarter, BrickRotation.ThreeQuarter -> {
                        arrayOf(arrayOf(true), arrayOf(true), arrayOf(true), arrayOf(true))
                    }
                }
            }

            TetrisBrickShape.S -> {
                return when (rotation) {
                    BrickRotation.Original, BrickRotation.Half -> {
                        arrayOf(arrayOf(false, true, true), arrayOf(true, true, false))
                    }
                    BrickRotation.Quarter, BrickRotation.ThreeQuarter -> {
                        arrayOf(arrayOf(true, false), arrayOf(true, true), arrayOf(false, true))
                    }
                }
            }

            TetrisBrickShape.Z -> {
                return when (rotation) {
                    BrickRotation.Original, BrickRotation.Half -> {
                        arrayOf(arrayOf(true, true, false), arrayOf(false, true, true))
                    }
                    BrickRotation.Quarter, BrickRotation.ThreeQuarter -> {
                        arrayOf(arrayOf(false, true), arrayOf(true, true), arrayOf(true, false))
                    }
                }
            }

            TetrisBrickShape.T -> {
                return when (rotation) {
                    BrickRotation.Original -> {
                        arrayOf(arrayOf(true, true, true), arrayOf(false, true, false))
                    }
                    BrickRotation.Quarter -> {
                        arrayOf(arrayOf(false, true), arrayOf(true, true), arrayOf(false, true))
                    }
                    BrickRotation.Half -> {
                        arrayOf(arrayOf(false, true, false), arrayOf(true, true, true))
                    }
                    BrickRotation.ThreeQuarter -> {
                        arrayOf(arrayOf(true, false), arrayOf(true, true), arrayOf(true, false))
                    }
                }
            }

            TetrisBrickShape.J -> {
                return when (rotation) {
                    BrickRotation.Original -> {
                        arrayOf(arrayOf(true, false, false), arrayOf(true, true, true))
                    }
                    BrickRotation.Quarter -> {
                        arrayOf(arrayOf(false, true), arrayOf(false, true), arrayOf(true, true))
                    }
                    BrickRotation.Half -> {
                        arrayOf(arrayOf(true, true, true), arrayOf(false, false, true))
                    }
                    BrickRotation.ThreeQuarter -> {
                        arrayOf(arrayOf(true, true), arrayOf(true, false), arrayOf(true, false))
                    }
                }
            }

            TetrisBrickShape.L -> {
                return when (rotation) {
                    BrickRotation.Original -> {
                        arrayOf(arrayOf(true, true, true), arrayOf(true, false, false))
                    }
                    BrickRotation.Quarter -> {
                        arrayOf(arrayOf(true, true), arrayOf(false, true), arrayOf(false, true))
                    }
                    BrickRotation.Half -> {
                        arrayOf(arrayOf(false, false, true), arrayOf(true, true, true))
                    }
                    BrickRotation.ThreeQuarter -> {
                        arrayOf(arrayOf(true, false), arrayOf(true, false), arrayOf(true, true))
                    }
                }
            }
        }
    }

    private fun calculatePosition(shape: TetrisBrickShape, rotation: BrickRotation): Int {
        val range = if (shape == TetrisBrickShape.I) {
            if (rotation == BrickRotation.Original || rotation == BrickRotation.Half) {
                12
            } else {
                9
            }
        } else if (shape == TetrisBrickShape.J || shape == TetrisBrickShape.L || shape == TetrisBrickShape.S || shape == TetrisBrickShape.Z) {
            if (rotation == BrickRotation.Original || rotation == BrickRotation.Half) {
                10
            } else {
                11
            }
        } else {
            11
        }
        return repo.getRandomStartPosition(range)
    }
}
