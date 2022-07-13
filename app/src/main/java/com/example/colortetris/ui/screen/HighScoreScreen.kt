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
import com.example.colortetris.ui.viewModel.HighScoreViewModel
import org.koin.androidx.compose.getViewModel

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
    val viewModel = getViewModel<HighScoreViewModel>()

    Text(
        text = "HIGH SCORE",
        modifier = Modifier.padding(vertical = 10.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    )
    Text(
        text = "1. ${viewModel.savedFirstScore}",
        modifier = Modifier.padding(vertical = 10.dp),
    )
    Text(
        text = "2. ${viewModel.savedSecondScore}",
        modifier = Modifier.padding(vertical = 10.dp),
    )
    Text(
        text = "3. ${viewModel.savedThirdScore}",
        modifier = Modifier.padding(vertical = 10.dp),
    )
    Text(
        text = "4. ${viewModel.savedForthScore}",
        modifier = Modifier.padding(vertical = 10.dp),
    )
    Text(
        text = "5. ${viewModel.savedFifthScore}",
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