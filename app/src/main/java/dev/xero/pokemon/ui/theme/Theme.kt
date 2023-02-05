package dev.xero.pokemon.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
	background = black,
	surface = surface,
	primary = accent_1,
	onSurface = inactive,
	onPrimary = white,
)

private val LightColorPalette = lightColors(
	background = black,
	surface = surface,
	primary = accent_1,
	onSurface = inactive,
	onPrimary = white,
)

@Composable
fun PokemonTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
	val colors = if (darkTheme) {
		DarkColorPalette
	} else {
		LightColorPalette
	}

	MaterialTheme(
		colors = colors,
		typography = Typography,
		shapes = Shapes,
		content = content
	)
}