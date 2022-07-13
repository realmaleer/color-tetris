package com.example.colortetris.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.colortetris.ui.viewModel.GameViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun GameScreen(
    confirmResultAction: () -> Unit
) {
    val gameViewModel = getViewModel<GameViewModel>()
    val isShowResult = gameViewModel.isShowResult.collectAsState(initial = false)

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
}

@Composable
fun GameBody() {
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
            TimeView(modifier)

            // Score
            ScoreView(modifier)

            // Blocks
            BlocksView(modifier)

            // Speed
            SpeedView(modifier)

            // Next
            NextView(modifier)
        }
    }
}

@Composable
fun TimeView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Time")
        Text(text = "00:00")
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
fun NextView(modifier: Modifier = Modifier) {
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
                            .border(width = 1.dp, color = Color.LightGray),
                        contentAlignment = Alignment.Center,
                    ) {
                    }
                }
            }
        }
    }
}

@Composable
fun ControlArea(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Direction Area
        Box(
            modifier = Modifier
                .weight(0.55f)
                .padding(start = 30.dp)
                .aspectRatio(1f),
            contentAlignment = Alignment.CenterEnd,
        ) {
            DirectionButton()
        }

        // Rotate Area
        Box(
            modifier = Modifier
                .padding(end = 30.dp)
                .weight(0.35f),
            contentAlignment = Alignment.CenterEnd,
        ) {
            RotateButton()
        }
    }
}

@Composable
fun DirectionButton() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black,
    ) {
        Box(
            modifier = Modifier.size(80.dp),
            contentAlignment = Alignment.TopCenter,
        ) {
            Button(
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = CircleShape),
                onClick = {},
                contentPadding = PaddingValues(
                    start = 1.dp,
                    top = 1.dp,
                    end = 1.dp,
                    bottom = 1.dp
                ),
            ) {
                Text(text = "UP")
            }
        }
        Box(
            modifier = Modifier.size(80.dp),
            contentAlignment = Alignment.CenterStart,
        ) {
            Button(
                modifier = Modifier
                    .size(80.dp)
                    .padding(horizontal = 1.dp)
                    .clip(shape = CircleShape),
                onClick = {},
                contentPadding = PaddingValues(
                    start = 1.dp,
                    top = 1.dp,
                    end = 1.dp,
                    bottom = 1.dp
                ),
            ) {
                Text(text = "LEFT")
            }
        }
        Box(
            modifier = Modifier.size(80.dp),
            contentAlignment = Alignment.CenterEnd,
        ) {
            Button(
                modifier = Modifier
                    .size(80.dp)
                    .padding(horizontal = 1.dp)
                    .clip(shape = CircleShape),
                onClick = {},
                contentPadding = PaddingValues(
                    start = 1.dp,
                    top = 1.dp,
                    end = 1.dp,
                    bottom = 1.dp
                ),
            ) {
                Text(text = "RIGHT")
            }
        }
        Box(
            modifier = Modifier.size(80.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = CircleShape),
                onClick = {},
                contentPadding = PaddingValues(
                    start = 1.dp,
                    top = 1.dp,
                    end = 1.dp,
                    bottom = 1.dp
                ),
            ) {
                Text(text = "DOWN")
            }
        }
    }
}

@Composable
fun RotateButton() {
    Button(
        modifier = Modifier
            .size(80.dp)
            .clip(shape = CircleShape),
        onClick = {},
        contentPadding = PaddingValues(
            start = 1.dp,
            top = 1.dp,
            end = 1.dp,
            bottom = 1.dp
        ),
    ) {
        Text(
            text = "ROTATE",
            fontSize = 13.sp,
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