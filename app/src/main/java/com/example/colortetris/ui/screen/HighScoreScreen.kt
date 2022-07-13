package com.example.colortetris.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.colortetris.repository.HighScoreRepo

@Composable
fun HighScoreScreen(
    onClickBackToMenuButtonAction: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        HighScoreView()

        Spacer(modifier = Modifier.height(30.dp))

        BackToMenuButton(onClickBackToMenuButtonAction)
    }
}

@Composable
fun HighScoreView() {
    val highScoreRepo = remember { HighScoreRepo() }
    var savedFirstScore: Int by remember { mutableStateOf(0) }
    var savedSecondScore: Int by remember { mutableStateOf(0) }
    var savedThirdScore: Int by remember { mutableStateOf(0) }
    var savedForthScore: Int by remember { mutableStateOf(0) }
    var savedFifthScore: Int by remember { mutableStateOf(0) }

    Text(
        text = "HIGH SCORE",
        modifier = Modifier.padding(vertical = 10.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    )
    Text(
        text = "1. $savedFirstScore",
        modifier = Modifier.padding(vertical = 10.dp),
    )
    Text(
        text = "2. $savedSecondScore",
        modifier = Modifier.padding(vertical = 10.dp),
    )
    Text(
        text = "3. $savedThirdScore",
        modifier = Modifier.padding(vertical = 10.dp),
    )
    Text(
        text = "4. $savedForthScore",
        modifier = Modifier.padding(vertical = 10.dp),
    )
    Text(
        text = "5. $savedFifthScore",
        modifier = Modifier.padding(vertical = 10.dp),
    )
}

@Composable
fun BackToMenuButton(
    onClickBackToMenuButtonAction: () -> Unit,
) {
    Button(
        onClick = { onClickBackToMenuButtonAction() }
    ) {
        Text(text = "Back To Menu")
    }
}