package com.example.colortetris.storage

interface HighScoreStorage {
    fun putFirstScore(key: String, score: Int)
    fun getFirstScore(key: String): Int
    fun putSecondScore(key: String, score: Int)
    fun getSecondScore(key: String): Int
    fun putThirdScore(key: String, score: Int)
    fun getThirdScore(key: String): Int
    fun putForthScore(key: String, score: Int)
    fun getForthScore(key: String): Int
    fun putFifthScore(key: String, score: Int)
    fun getFifthScore(key: String): Int
}