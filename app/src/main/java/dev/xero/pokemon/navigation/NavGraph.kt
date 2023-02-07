package dev.xero.pokemon.navigation

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.xero.pokemon.AnimatedSplashScreen
import dev.xero.pokemon.PokemonApp
import dev.xero.pokemon.ui.theme.black

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
	NavHost(
		navController = navHostController,
		startDestination = Screen.Splash.route
	) {
		composable(route = Screen.Splash.route) {
			AnimatedSplashScreen(navHostController = navHostController)
		}

		composable(route = Screen.Home.route) {
			Surface(color = black) {
				PokemonApp()
			}
		}
	}
}