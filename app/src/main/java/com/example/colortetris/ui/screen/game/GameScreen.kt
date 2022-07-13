package com.example.colortetris.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.colortetris.ui.screen.game.ControlArea
import com.example.colortetris.ui.screen.game.GameBody
import com.example.colortetris.ui.viewModel.GameViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun GameScreen(
    confirmResultAction: () -> Unit
) {
    val gameViewModel = getViewModel<GameViewModel>()
    val isShowResult = gameViewModel.isShowResult.collectAsState(initial = false)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            // GameBody
            Box(
                modifier = Modifier.weight(2f)
            ) {
                GameBody()
            }

            // Control Movement Area
            Box(
                modifier = Modifier.weight(1f)
            ) {
                ControlArea()
            }

            // Alert for Game Result
            GameResultView(confirmResultAction, isShowResult.value)
        }

        // Countdown for game start
        CountDownView(
            Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun CountDownView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.height(100.dp)
    ) {
        Text(
            text = "3",
            color = Color.Black,
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}

@Composable
fun GameResultView(
    confirmResultAction: () -> Unit,
    isShowResult: Boolean,
) {
    if (isShowResult) {
        AlertDialog(
            onDismissRequest = { },
            text = { Text("Score: 1000") },
            confirmButton = {
                Button(
                    onClick = { confirmResultAction() }
                ) {
                    Text(text = "Back To Menu")
                }
            }
        )
    }
}