package dev.xero.pokemon.data

import dev.xero.pokemon.R
import dev.xero.pokemon.models.Pokemon

/**
 * Data Source for all the pokemons in this app
 * */
class PokemonData {
	val pokemonData: List<Pokemon> = listOf<Pokemon>(
		Pokemon(
			number = 1,
			imageResID = R.drawable.bulbasaur,
			nameResID = R.string.bulbasaur,
			descriptionResID = R.string.bulbasaur_description,
			healthPower = 25,
			attackPower = 25,
			defensePower = 25,
			type = listOf("Grass", "Poison"),
			weaknesses = listOf("Fire", "Ice", "Psychic")
		),

		Pokemon(
			number = 2,
			imageResID = R.drawable.ivysaur,
			nameResID = R.string.ivysaur,
			descriptionResID = R.string.ivysaur_description,
			healthPower = 25,
			attackPower = 25,
			defensePower = 30,
			type = listOf("Grass", "Poison"),
			weaknesses = listOf("Fire", "Ice", "Psychic")
		),

	)
}