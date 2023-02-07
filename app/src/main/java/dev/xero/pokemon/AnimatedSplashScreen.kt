package dev.xero.pokemon

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.xero.pokemon.navigation.Screen
import dev.xero.pokemon.ui.theme.black
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navHostController: NavHostController) {
	var startAnimation by remember {
		mutableStateOf(false)
	}
	val alphaAnim = animateFloatAsState(
		targetValue = if (startAnimation) 1f else 0f,
		animationSpec = tween(
			durationMillis = 3000
		)
	)
	
	LaunchedEffect(key1 = true) {
		startAnimation = true
		delay(3000)
		navHostController.navigate(Screen.Home.route)
	}
	Splash(alpha = alphaAnim.value)
}


@Composable
fun Splash(
	modifier: Modifier = Modifier,
	alpha: Float
) {
	Box(
		modifier = modifier
			.background(black)
			.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		Image(
			painter = painterResource(id = R.drawable.ic_launcher_foreground),
			contentDescription = null,
			modifier = Modifier
				.size(240.dp)
				.alpha(alpha = alpha)
		)
	}
}