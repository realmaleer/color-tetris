package com.example.colortetris.repository

import com.example.colortetris.storage.HighScoreStorage
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class HighScoreRepo : KoinComponent {

    companion object {
        private const val STORAGE_NAME: String = "highScoreStorage"
        private const val KEY_FIRST_SCORE: String = "keyFirstScore"
        private const val KEY_SECOND_SCORE: String = "keySecondScore"
        private const val KEY_THIRD_SCORE: String = "keyThirdScore"
        private const val KEY_FORTH_SCORE: String = "keyForthScore"
        private const val KEY_FIFTH_SCORE: String = "keyFifthScore"
    }

    private val highScoreStorage: HighScoreStorage by inject() {
        parametersOf(
            STORAGE_NAME
        )
    }

    fun putFirstScore(score: Int) {
        highScoreStorage.putFirstScore(KEY_FIRST_SCORE, score)
    }

    fun getFirstScore(): Int {
        return highScoreStorage.getFirstScore(KEY_FIRST_SCORE)
    }

    fun putSecondScore(score: Int) {
        highScoreStorage.putSecondScore(KEY_SECOND_SCORE, score)
    }

    fun getSecondScore(): Int {
        return highScoreStorage.getSecondScore(KEY_SECOND_SCORE)
    }

    fun putThirdScore(score: Int) {
        highScoreStorage.putThirdScore(KEY_THIRD_SCORE, score)
    }

    fun getThirdScore(): Int {
        return highScoreStorage.getThirdScore(KEY_THIRD_SCORE)
    }

    fun putForthScore(score: Int) {
        highScoreStorage.putForthScore(KEY_FORTH_SCORE, score)
    }

    fun getForthScore(): Int {
        return highScoreStorage.getForthScore(KEY_FORTH_SCORE)
    }

    fun putFifthScore(score: Int) {
        highScoreStorage.putFifthScore(KEY_FIFTH_SCORE, score)
    }

    fun getFifthScore(): Int {
        return highScoreStorage.getFifthScore(KEY_FIFTH_SCORE)
    }
}