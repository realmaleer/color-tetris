package com.example.colortetris.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    Text(
        text = "HIGH SCORE",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
    )
    Text(
        text = "1." + "12345",
        modifier = Modifier.padding(vertical = 10.dp),
    )
    Text(
        text = "2." + "12346",
        modifier = Modifier.padding(vertical = 10.dp),
    )
    Text(
        text = "3." + "12347",
        modifier = Modifier.padding(vertical = 10.dp),
    )
    Text(
        text = "4." + "12348",
        modifier = Modifier.padding(vertical = 10.dp),
    )
    Text(
        text = "5." + "12349",
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