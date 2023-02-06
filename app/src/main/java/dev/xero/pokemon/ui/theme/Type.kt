package dev.xero.pokemon.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.xero.pokemon.R

val Outfit = FontFamily(
	Font(R.font.outfit_medium, FontWeight.Medium),
	Font(R.font.outfit_bold, FontWeight.Bold)
)

val Typography = Typography(
	h1 = TextStyle(
		fontFamily = Outfit,
		fontWeight = FontWeight.Bold,
		fontSize = 64.sp
	),

	h2 = TextStyle(
		fontFamily = Outfit,
		fontWeight = FontWeight.Bold,
		fontSize = 36.sp
	),

	h3 = TextStyle(
		fontFamily = Outfit,
		fontWeight = FontWeight.Bold,
		fontSize = 24.sp
	),

	h4 = TextStyle(
		fontFamily = Outfit,
		fontWeight = FontWeight.Bold,
		fontSize = 20.sp
	),

	h5 = TextStyle(
		fontFamily = Outfit,
		fontWeight = FontWeight.Bold,
		fontSize = 14.sp
	),

	subtitle2 = TextStyle(
		fontFamily = Outfit,
		fontWeight = FontWeight.Bold,
		fontSize = 28.sp
	),

	body1 = TextStyle(
		fontFamily = Outfit,
		fontWeight = FontWeight.Medium,
		fontSize = 14.sp
	),
)