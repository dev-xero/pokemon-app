package dev.xero.pokemon.models

import androidx.compose.ui.graphics.Color

/**
 * Data class containing the [MapOfTypeToColor]] for each element
 * */
class MapOfTypeToColor {
	val mapOfTypeToColor: Map<String, Color> = mapOf<String, Color>(
		"Grass" to Color(0xFF52EF87),
		"Fire" to Color(0xFFEF526E),
		"Electric" to Color(0xFF7D3FF1),
		"Ice" to Color(0xFF5685E0),
		"Water" to Color(0xFF465BE6),
		"Rock" to Color(0xFF864E3D),
		"Bug" to Color(0xFF51CA37),
		"Poison" to Color(0xFFBC56E0),
		"Psychic" to Color(0xFFF153BC)
	)
}