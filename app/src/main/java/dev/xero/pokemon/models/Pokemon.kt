package dev.xero.pokemon.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Data class for each [Pokemon]
 *
 * models what properties each pokemon instance should have
 * @param number [[Int]] Number on the list
 * @param imageResID [[DrawableRes]] Res ID for this Pokemon's image
 * @param nameResID [[StringRes]] Res ID for this Pokemon's name
 * @param descriptionResID [[StringRes]] Res ID for this Pokemon's description
 * @param healthPower [[Int]] HP for this Pokemon
 * @param attackPower [[Int]] AP for this Pokemon
 * @param defensePower [[Int]] DF for this Pokemon
 * @param type [MapOfTypeToColor] List of types for this pokemon
 * @param weaknesses [MapOfTypeToColor] List of weaknesses for this pokemon
 * */
data class Pokemon (
	val number: Int,
	@DrawableRes val imageResID: Int,
	@StringRes val nameResID: Int,
	@StringRes val descriptionResID: Int,
	val healthPower: Int,
	val attackPower: Int,
	val defensePower: Int,
	val type: List<MapOfTypeToColor>,
	val weaknesses: List<MapOfTypeToColor>,
)