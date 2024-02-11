package android.mkv.newsappcompose

import android.mkv.newsappcompose.presentation.navgraph.NavGraph
import android.mkv.newsappcompose.presentation.onborading.OnBoardingScreen
import android.mkv.newsappcompose.ui.theme.NewsAppComposeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }
        setContent {
            NewsAppComposeTheme {
                Surface {
                    Box(modifier = Modifier.fillMaxSize()) {

                        val startDestination = viewModel.startDestination
                        NavGraph(startDestination = startDestination)

                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun MainPreview() {
    NewsAppComposeTheme {
        Surface {
            OnBoardingScreen() {}
        }
    }
}