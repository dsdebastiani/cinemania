package io.github.dsdebastiani.cinemania.ui.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.dsdebastiani.cinemania.features.movies.HomeRoute

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeRoute {
                /* navController.navigate("details/{movieId}") */
                Toast.makeText(
                    navController.context,
                    "navigate(\"details/$it\")",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
