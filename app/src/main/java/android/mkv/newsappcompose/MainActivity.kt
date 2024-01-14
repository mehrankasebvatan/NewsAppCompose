package android.mkv.newsappcompose

import android.mkv.newsappcompose.domain.usecases.AppEntryUseCases
import android.mkv.newsappcompose.presentation.onborading.OnBoardingScreen.OnBoardingScreen
import android.mkv.newsappcompose.ui.theme.NewsAppComposeTheme
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()

        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect {
                Log.d("appEntryUseCases", "onCreate: $it")
            }
        }
        setContent {
            NewsAppComposeTheme {
                Surface {
                    Box(modifier = Modifier.fillMaxSize()) {
                        OnBoardingScreen()
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
            OnBoardingScreen()
        }
    }
}