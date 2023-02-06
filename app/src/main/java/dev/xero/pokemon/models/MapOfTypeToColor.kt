package dev.xero.pokemon.models

import androidx.compose.ui.graphics.Color

/**
 * Data class containing the [MapOfTypeToColor]] for each element
 * */
class MapOfTypeToColor {
	val mapOfTypeToColor: Map<String, Color> = mapOf<String, Color>(
		"Grass" to Color(0xFF52EF87),
		"Fire" to Color(0xFFEF526E),
		"Electric" to Color(0xFFF7C545),
		"Normal" to Color(0xFF89A4B6),
		"Fighting" to Color(0xFFFF9437),
		"Ice" to Color(0xFF5685E0),
		"Water" to Color(0xFF465BE6),
		"Rock" to Color(0xFF864E3D),
		"Ground" to Color(0xFFBEAB64),
		"Bug" to Color(0xFF51CA37),
		"Poison" to Color(0xFFBC56E0),
		"Psychic" to Color(0xFFF153BC)
	)
}