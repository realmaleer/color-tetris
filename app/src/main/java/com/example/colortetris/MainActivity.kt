package com.example.colortetris

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.colortetris.ui.screen.HighScoreScreen
import com.example.colortetris.ui.screen.MainScreen
import com.example.colortetris.ui.screen.StartScreen
import com.example.colortetris.ui.theme.ColorTetrisTheme
import com.example.colortetris.ui.viewModel.PagerViewModel

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
                    val viewModel: PagerViewModel = viewModel()
                    val currentPage = viewModel.currentPage.collectAsState(initial = 1)

                    when (currentPage.value) {
                        0 -> {
                            MainScreen()
                        }

                        1 -> {
                            StartScreen(
                                { viewModel.updateCurrentPage(0) },
                                { viewModel.updateCurrentPage(2) },
                            )
                        }

                        2 -> {
                            HighScoreScreen()
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