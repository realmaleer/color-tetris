package com.example.colortetris.logic

import com.example.colortetris.model.BrickRotation
import com.example.colortetris.model.TetrisBrick
import com.example.colortetris.model.TetrisBrickShape
import com.example.colortetris.repository.GameStateRepo
import kotlinx.coroutines.delay

class GameStateLogic(private val repo: GameStateRepo) {
    val isGameEnd = repo.isGameEnd
    val isGameStart = repo.isGameStart
    val usedTime = repo.usedTime
    val cdTime = repo.cdTime
    val isBrickUsed = repo.isBrickUsed
    val nextBrick = repo.nextBrick
    val currentBrick = repo.currentBrick

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
        while (cdTime.value <= 4) {
            delay(1000)
            repo.putCDTime(cdTime.value + 1)
        }
        repo.putGameStartStatus(true)
        generateBrick()
        generateBrick()
    }

    fun generateBrickModel(
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

    fun calculatePosition(shape: TetrisBrickShape, rotation: BrickRotation): Int {
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
