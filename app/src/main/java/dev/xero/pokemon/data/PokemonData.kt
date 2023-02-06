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

		Pokemon(
			number = 3,
			imageResID = R.drawable.venusaur,
			nameResID = R.string.venusaur,
			descriptionResID = R.string.venusaur_description,
			healthPower = 30,
			attackPower = 30,
			defensePower = 30,
			type = listOf("Grass", "Poison"),
			weaknesses = listOf("Fire", "Ice", "Psychic")
		),

		Pokemon(
			number = 4,
			imageResID = R.drawable.charmander,
			nameResID = R.string.charmander,
			descriptionResID = R.string.charizard_description,
			healthPower = 20,
			attackPower = 25,
			defensePower = 20,
			type = listOf("Fire"),
			weaknesses = listOf("Water", "Rock")
		),

		Pokemon(
			number = 5,
			imageResID = R.drawable.charmeleon,
			nameResID = R.string.charmeleon,
			descriptionResID = R.string.charmeleon_description,
			healthPower = 25,
			attackPower = 25,
			defensePower = 25,
			type = listOf("Fire"),
			weaknesses = listOf("Water", "Rock")
		),

		Pokemon(
			number = 6,
			imageResID = R.drawable.charizard,
			nameResID = R.string.charizard,
			descriptionResID = R.string.charizard_description,
			healthPower = 30,
			attackPower = 30,
			defensePower = 30,
			type = listOf("Fire"),
			weaknesses = listOf("Water", "Rock")
		),

		Pokemon(
			number = 7,
			imageResID = R.drawable.squirtle,
			nameResID = R.string.squirtle,
			descriptionResID = R.string.squirtle_description,
			healthPower = 20,
			attackPower = 20,
			defensePower = 20,
			type = listOf("Water"),
			weaknesses = listOf("Grass", "Electric")
		),

		Pokemon(
			number = 8,
			imageResID = R.drawable.wartortle,
			nameResID = R.string.wartortle,
			descriptionResID = R.string.wartortle_description,
			healthPower = 25,
			attackPower = 25,
			defensePower = 30,
			type = listOf("Water"),
			weaknesses = listOf("Grass", "Electric")
		),

		Pokemon(
			number = 9,
			imageResID = R.drawable.blastoise,
			nameResID = R.string.blastoise,
			descriptionResID = R.string.blastoise_description,
			healthPower = 30,
			attackPower = 30,
			defensePower = 40,
			type = listOf("Water"),
			weaknesses = listOf("Grass", "Electric")
		),

		Pokemon(
			number = 10,
			imageResID = R.drawable.caterpie,
			nameResID = R.string.caterpie,
			descriptionResID = R.string.caterpie_description,
			healthPower = 15,
			attackPower = 20,
			defensePower = 15,
			type = listOf("Bug"),
			weaknesses = listOf("Fire", "Rock")
		),

		Pokemon(
			number = 11,
			imageResID = R.drawable.metapod,
			nameResID = R.string.metapod,
			descriptionResID = R.string.metapod_description,
			healthPower = 20,
			attackPower = 15,
			defensePower = 25,
			type = listOf("Bug"),
			weaknesses = listOf("Fire", "Rock")
		),

		Pokemon(
			number = 12,
			imageResID = R.drawable.butterfree,
			nameResID = R.string.butterfree,
			descriptionResID = R.string.butterfree_description,
			healthPower = 25,
			attackPower = 20,
			defensePower = 20,
			type = listOf("Bug"),
			weaknesses = listOf("Fire", "Rock", "Electric")
		),

		Pokemon(
			number = 13,
			imageResID = R.drawable.weedle,
			nameResID = R.string.weedle,
			descriptionResID = R.string.weedle_description,
			healthPower = 20,
			attackPower = 20,
			defensePower = 15,
			type = listOf("Bug", "Poison"),
			weaknesses = listOf("Fire", "Rock", "Psychic")
		),

		Pokemon(
			number = 14,
			imageResID = R.drawable.kakuna,
			nameResID = R.string.kakuna,
			descriptionResID = R.string.kakuna_description,
			healthPower = 20,
			attackPower = 15,
			defensePower = 20,
			type = listOf("Bug", "Poison"),
			weaknesses = listOf("Fire", "Rock", "Psychic")
		),

		Pokemon(
			number = 15,
			imageResID = R.drawable.beedrill,
			nameResID = R.string.beedrill,
			descriptionResID = R.string.beedrill_description,
			healthPower = 25,
			attackPower = 40,
			defensePower = 20,
			type = listOf("Bug", "Poison"),
			weaknesses = listOf("Fire", "Psychic", "Rock")
		),

		Pokemon(
			number = 16,
			imageResID = R.drawable.pidgey,
			nameResID = R.string.pidgey,
			descriptionResID = R.string.pidgey_description,
			healthPower = 20,
			attackPower = 20,
			defensePower = 20,
			type = listOf("Normal"),
			weaknesses = listOf("Electric", "Ice", "Rock")
		),

	)
}