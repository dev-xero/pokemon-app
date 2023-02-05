package dev.xero.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.xero.pokemon.data.PokemonData
import dev.xero.pokemon.models.Pokemon
import dev.xero.pokemon.ui.theme.PokemonTheme

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
			modifier = Modifier.padding(padding)
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
			.padding(18.dp),
		elevation = 0.dp
	) {
		var expanded by remember { mutableStateOf(false) }

		Column(
			modifier = Modifier.fillMaxWidth()
		) {
			// POKEMON NUMBER
			Text(
				text = pokemon.number.toString(),
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
			Column {
				Row(
					modifier = Modifier
						.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween,
					verticalAlignment = Alignment.CenterVertically
				) {
					Text(
						text = stringResource(id = pokemon.nameResID),
						maxLines = 1,
						overflow = TextOverflow.Ellipsis
					)

					IconButton(
						onClick = { /*TODO*/ }
					) {
						val icon = if (expanded) R.drawable.up_arrow else R.drawable.down_arrow
						Icon(
							painter = painterResource(id = icon),
							contentDescription = null,
							modifier = modifier.size(12.dp)
						)
					}
				}
				Text(
					text = stringResource(id = pokemon.descriptionResID),
					maxLines = 2,
					overflow = TextOverflow.Ellipsis
				)
			}
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