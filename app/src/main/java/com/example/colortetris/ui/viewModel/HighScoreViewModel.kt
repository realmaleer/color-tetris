package com.example.colortetris.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.colortetris.repository.HighScoreRepo

class HighScoreViewModel(
    repo: HighScoreRepo,
) : ViewModel() {
    var savedFirstScore: Int by mutableStateOf(0)
    var savedSecondScore: Int by mutableStateOf(0)
    var savedThirdScore: Int by mutableStateOf(0)
    var savedForthScore: Int by mutableStateOf(0)
    var savedFifthScore: Int by mutableStateOf(0)

    init {
        savedFirstScore = repo.getFirstScore()
        savedSecondScore = repo.getSecondScore()
        savedThirdScore = repo.getForthScore()
        savedForthScore = repo.getForthScore()
        savedFifthScore = repo.getFifthScore()
    }
}