package com.example.colortetris.ui.screen.game

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GameBody(
    displayedUsedTime: String,
    displayNextBrick: Array<Array<Color>>,
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Playing Area
        Column(
            modifier = Modifier
                .weight(1.6f)
                .padding(start = 30.dp)
                .border(width = 1.dp, color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            for (i in 1..24) {
                Row {
                    for (j in 1..12) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .border(width = 0.3.dp, color = Color.LightGray),
                            contentAlignment = Alignment.Center,
                        ) {
                        }
                    }
                }
            }
        }

        // GamePlay Information Area
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            val modifier = Modifier.weight(1f)

            // Time
            TimeView(
                modifier,
                displayedUsedTime,
            )

            // Score
            ScoreView(modifier)

            // Blocks
            BlocksView(modifier)

            // Speed
            SpeedView(modifier)

            // Next
            NextView(
                modifier,
                displayNextBrick,
            )
        }
    }
}

@Composable
fun TimeView(
    modifier: Modifier = Modifier,
    displayedUsedTime: String,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Time")
        Text(text = displayedUsedTime)
    }
}

@Composable
fun ScoreView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "SCORE")
        Text(text = "0")
    }
}

@Composable
fun BlocksView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "BLOCKS")
        Text(text = "0")
    }
}

@Composable
fun SpeedView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "SPEED")
        Text(text = "1")
    }
}

@Composable
fun NextView(
    modifier: Modifier = Modifier,
    displayNextBrick: Array<Array<Color>>,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "NEXT")
        Spacer(modifier = Modifier.height(8.dp))
        for (i in 1..2) {
            Row {
                for (j in 1..4) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .aspectRatio(1f)
                            .background(color = displayNextBrick[i - 1][j - 1])
                            .border(width = 1.dp, color = Color.LightGray),
                        contentAlignment = Alignment.Center,
                    ) {
                    }
                }
            }
        }
    }
}