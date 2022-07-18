package com.example.colortetris.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.colortetris.ui.viewModel.GameViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    onClickStartGameButtonAction: () -> Unit,
    onClickHighScoreButtonAction: () -> Unit,
) {
    val gameViewModel = getViewModel<GameViewModel>()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        StartGameButton(
            onClickStartGameButtonAction,
            enterGameAction = { gameViewModel.enterGameScreenAction() }
        )
        HighScoreButton(onClickHighScoreButtonAction)
    }
}

@Composable
fun StartGameButton(
    onClickStartGameButtonAction: () -> Unit,
    enterGameAction: () -> Unit,
) {
    Button(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .size(width = 150.dp, height = 40.dp),
        onClick = {
            enterGameAction()
            onClickStartGameButtonAction()
        },
    ) {
        Text(text = "START")
    }
}

@Composable
fun HighScoreButton(
    onClickHighScoreButtonAction: () -> Unit,
) {
    Button(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .size(width = 150.dp, height = 40.dp),
        onClick = { onClickHighScoreButtonAction() },
    ) {
        Text(text = "HIGH SCORE")
    }
}