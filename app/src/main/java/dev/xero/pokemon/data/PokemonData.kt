package dev.xero.pokemon.data

import dev.xero.pokemon.models.Pokemon

/**
 * Data Source for all the pokemons in this app
 * */
class PokemonData {
	val pokemonData: List<Pokemon> = listOf<Pokemon>(
		Pokemon(
			number = 1,
			imageResID = 0,
			nameResID = 0,
			descriptionResID = 0,
			healthPower = 0,
			attackPower = 0,
			defensePower = 0,
			type = listOf("Grass", "Poison"),
			weaknesses = listOf("Fire", "Ice", "Psychic")
		)

	)
}