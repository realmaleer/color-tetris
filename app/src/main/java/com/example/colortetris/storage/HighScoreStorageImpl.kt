package com.example.colortetris.storage

import android.content.SharedPreferences
import com.example.colortetris.ulits.context

class HighScoreStorageImpl constructor(storageName: String) : HighScoreStorage {

    private val sharedPref: SharedPreferences = context.getSharedPreferences(storageName, 0)

    override fun putFirstScore(key: String, score: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(key, score)
        editor.commit()
    }

    override fun getFirstScore(key: String): Int {
        return sharedPref.getInt(key, 0)
    }

    override fun putSecondScore(key: String, score: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(key, score)
        editor.commit()
    }

    override fun getSecondScore(key: String): Int {
        return sharedPref.getInt(key, 0)
    }

    override fun putThirdScore(key: String, score: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(key, score)
        editor.commit()
    }

    override fun getThirdScore(key: String): Int {
        return sharedPref.getInt(key, 0)
    }

    override fun putForthScore(key: String, score: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(key, score)
        editor.commit()
    }

    override fun getForthScore(key: String): Int {
        return sharedPref.getInt(key, 0)
    }

    override fun putFifthScore(key: String, score: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(key, score)
        editor.commit()
    }

    override fun getFifthScore(key: String): Int {
        return sharedPref.getInt(key, 0)
    }

}