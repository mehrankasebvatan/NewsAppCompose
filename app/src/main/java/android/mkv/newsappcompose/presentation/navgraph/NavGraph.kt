package android.mkv.newsappcompose.presentation.navgraph

import android.mkv.newsappcompose.presentation.onborading.OnBoardingScreen
import android.mkv.newsappcompose.presentation.onborading.OnBoardingViewModel
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {

        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {

                val viewModel: OnBoardingViewModel = viewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )

            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(
                route = Route.NewsNavigatorScreen.route
            ) {
                Text(text = "News Navigator Screen")
            }
        }


    }

}