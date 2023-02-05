package dev.xero.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.xero.pokemon.data.PokemonData
import dev.xero.pokemon.models.MapOfTypeToColor
import dev.xero.pokemon.models.Pokemon
import dev.xero.pokemon.ui.theme.*

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PokemonTheme {
				PokemonApp()
			}
		}
	}
}

/**
 * Composable for the Pokemon app
 * @param modifier [[Modifier]] Modifier for this composable
 * */
@Composable
fun PokemonApp(
	modifier: Modifier = Modifier
) {
	Scaffold {
		padding ->
		LazyColumn(
			modifier = Modifier.padding(padding),
			verticalArrangement = Arrangement.spacedBy(12.dp)
		) {
			items(PokemonData().pokemonData) {
				pokemon -> PokemonItem(pokemon = pokemon)
			}
		}
	}
}

/**
 * Composable describing how the pokemon card should look like
 * @param modifier [[Modifier]] Modifier for this composable
 * @param pokemon [[Pokemon]] Pokemon model to get it's attributes from
 * */
@Composable
fun PokemonItem(
	modifier: Modifier = Modifier,
	pokemon: Pokemon
) {
	Card(
		modifier = modifier
			.fillMaxWidth()
			.padding(horizontal = 12.dp),
		elevation = 0.dp
	) {
		var expanded by remember { mutableStateOf(false) }

		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp)
		) {
			// POKEMON NUMBER
			Text(
				text = pokemon.number.toString(),
				style = MaterialTheme.typography.h1,
				color = accent_1
			)

			// POKEMON IMAGE
			Row(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.Center
			) {
				Image(
					painter = painterResource(id = pokemon.imageResID),
					contentDescription = null,
					modifier = Modifier.size(200.dp)
				)
			}

			// POKEMON DESCRIPTION
			Column(
				modifier = Modifier
					.padding(top = 8.dp)
			) {
				var lineHeight by remember { mutableStateOf(2) }
				Row(
					modifier = Modifier
						.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween,
					verticalAlignment = Alignment.CenterVertically
				) {
					Text(
						text = stringResource(id = pokemon.nameResID),
						style = MaterialTheme.typography.h2,
						maxLines = 1,
						overflow = TextOverflow.Ellipsis,
						color = white
					)

					IconButton(
						onClick = {
							expanded = !expanded
							lineHeight = when {
								expanded -> 5
								else -> 2
							}
						}
					) {
						val icon = if (!expanded) R.drawable.up_arrow else R.drawable.down_arrow
						Icon(
							painter = painterResource(id = icon),
							contentDescription = null,
							modifier = modifier.size(12.dp)
						)
					}
				}
				Text(
					text = stringResource(id = pokemon.descriptionResID),
					style = MaterialTheme.typography.body1,
					maxLines = lineHeight,
					overflow = TextOverflow.Ellipsis,
					modifier = Modifier.padding(bottom = 8.dp)
				)
			}

			if (expanded) {
				// POKEMON EXTRA INFO
				PokemonExtraInfo(pokemon = pokemon)
			}
		}
	}

}


/**
 * Composable to show the type and weaknesses of each Pokemon
 * @param modifier [[Modifier]] Modifier for this composable
 * @param pokemon [[Pokemon]] Data Source for this Pokemon
 * */
@Composable
fun PokemonExtraInfo(
	modifier: Modifier = Modifier,
	pokemon: Pokemon
) {
	Column(
		modifier = modifier
			.padding(vertical = 8.dp)
	) {
		// POKEMON TYPE
		Column(
			modifier = Modifier
				.fillMaxWidth()
		) {
			Text(
				text = stringResource(id = R.string.type),
				style = MaterialTheme.typography.h5,
				color = white
			)

			Row(
				modifier = Modifier
					.padding(top = 6.dp)
			) {
				TypeBox(types = pokemon.type)
			}
		}

		// POKEMON WEAKNESSES
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 16.dp)
		) {
			Text(
				text = stringResource(id = R.string.weaknesses),
				style = MaterialTheme.typography.h5,
				color = white
			)

			Row(
				modifier = Modifier
					.padding(top = 6.dp)
			) {
				TypeBox(types = pokemon.weaknesses)
			}
		}
	}
}

/**
 * Composable that displays the type of a Pokemon in a box
 * @param modifier [[Modifier]] Modifier for this composable
 * @param types [[List]] of types for this Pokemon
 * */
@Composable
fun TypeBox(
	modifier: Modifier = Modifier,
	types: List<String>
) {
	types.forEach {
		type ->
		Row(
			modifier = modifier
				.padding(end = 4.dp)
				.background(color = MapOfTypeToColor().mapOfTypeToColor[type]!!)
				.defaultMinSize(minWidth = 50.dp),
			horizontalArrangement = Arrangement.Center,
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				text = type,
				color = black,
				modifier = Modifier
					.padding(
						horizontal = 8.dp,
						vertical = 2.dp
					),
				style = TextStyle(
					fontWeight = FontWeight.Bold,
					fontSize = 12.sp,
					fontFamily = Outfit
				)
			)
		}
	}
}

/**
 * Composable to preview the pokemon item card
 * */
@Preview
@Composable
private fun PokemonPreview() {
	PokemonTheme {
		PokemonItem(pokemon = PokemonData().pokemonData[0])
	}
}