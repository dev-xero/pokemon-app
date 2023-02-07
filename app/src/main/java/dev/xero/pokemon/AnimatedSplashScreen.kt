package dev.xero.pokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.xero.pokemon.ui.theme.black

@Composable
fun AnimatedSplashScreen() {
	Splash()
}


@Composable
fun Splash(
	modifier: Modifier = Modifier
) {
	Box(
		modifier = modifier
			.background(black)
			.fillMaxSize()
	) {
		Image(
			painter = painterResource(id = R.drawable.ic_launcher_foreground),
			contentDescription = null,
			modifier = Modifier.size(120.dp)
		)
	}
}