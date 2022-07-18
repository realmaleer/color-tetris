package com.example.colortetris.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow

enum class TetrisBrickShape {
    I, J, L, O, S, T, Z
}

enum class BrickRotation {
    Original, Quarter, Half, ThreeQuarter
}

val TetrisBlocksColor = arrayOf(Black, Yellow, Red, Green, Blue, White, Cyan)


data class TetrisBrick(
    val shape: TetrisBrickShape,
    val rotation: BrickRotation,
    val color: Color,
)