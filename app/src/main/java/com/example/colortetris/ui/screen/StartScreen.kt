package com.example.colortetris.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StartScreen(
    onClickStartGameButtonAction: () -> Unit,
    onClickHighScoreButtonAction: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        StartGameButton(onClickStartGameButtonAction)
        HighScoreButton(onClickHighScoreButtonAction)
    }
}

@Composable
fun StartGameButton(
    onClickStartGameButtonAction: () -> Unit,
) {
    Button(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .size(width = 150.dp, height = 40.dp),
        onClick = { onClickStartGameButtonAction() },
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