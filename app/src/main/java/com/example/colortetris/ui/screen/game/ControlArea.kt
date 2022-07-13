package com.example.colortetris.ui.screen.game

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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