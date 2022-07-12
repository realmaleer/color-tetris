package com.example.colortetris.navigation

sealed class NavRoutes(val route: String) {
    object HighScore : NavRoutes("highScore")
    object Game : NavRoutes("game")
    object Home : NavRoutes("home")
}