package com.example.colortetris

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.colortetris.ui.screen.HighScoreScreen
import com.example.colortetris.ui.screen.MainScreen
import com.example.colortetris.ui.screen.StartScreen
import com.example.colortetris.ui.theme.ColorTetrisTheme
import com.example.colortetris.ui.viewModel.PagerAction
import com.example.colortetris.ui.viewModel.PagerViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
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
                    val pagerState = rememberPagerState(1)

                    LaunchedEffect(viewModel) {
                        viewModel.action.collectLatest {
                            when (it) {
                                is PagerAction.Scroll -> if (it.animated) {
                                    pagerState.animateScrollToPage(it.toPage)
                                } else {
                                    pagerState.scrollToPage(it.toPage)
                                }
                            }
                        }
                    }

                    when (pagerState.currentPage) {
                        0 -> {
                            MainScreen()
                        }

                        1 -> {
                            StartScreen { viewModel.scrollToPage(0, true) }
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