package com.example.colortetris

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.colortetris.navigation.NavRoutes
import com.example.colortetris.ui.screen.GameScreen
import com.example.colortetris.ui.screen.HighScoreScreen
import com.example.colortetris.ui.screen.HomeScreen
import com.example.colortetris.ui.theme.ColorTetrisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorTetrisTheme(true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = NavRoutes.Home.route,
                    ) {
                        composable(NavRoutes.Home.route) {
                            HomeScreen(
                                { navController.navigate(NavRoutes.Game.route) },
                                { navController.navigate(NavRoutes.HighScore.route) },
                            )
                        }

                        composable(NavRoutes.Game.route) {
                            GameScreen {
                                navController.navigate(NavRoutes.Home.route) {
                                    popUpTo(0)
                                }
                            }
                        }

                        composable(NavRoutes.HighScore.route) {
                            HighScoreScreen {
                                navController.navigateUp()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColorTetrisTheme {
        Greeting("Android")
    }
}