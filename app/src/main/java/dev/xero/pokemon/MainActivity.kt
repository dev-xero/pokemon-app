package dev.xero.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
	Scaffold(
		topBar = { AppBar() }
	) {
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
 * Composable for the app bar
 * @param modifier [[Modifier]] Modifier for this composable
 * */
@Composable
fun AppBar(
	modifier: Modifier = Modifier
) {
	Card(
		backgroundColor = black,
		modifier = Modifier.clip(
			shape = RoundedCornerShape(0.dp)
		)
	) {
		Column {
			Row(
				modifier = modifier
					.fillMaxWidth()
					.padding(12.dp),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Image(
					painter = painterResource(id = R.drawable.app_bar_icon),
					contentDescription = null,
					modifier = modifier.width(160.dp)
				)

				Text(
					text = stringResource(id = R.string.thirty_days),
					style = MaterialTheme.typography.h3,
					color = white
				)
			}
			
			Column(
				modifier = Modifier.padding(
					horizontal = 12.dp,
					vertical = 32.dp
				)
			) {
				Text(
					text = stringResource(id = R.string.title_first),
					style = MaterialTheme.typography.h4,
					color = inactive
				)

				Text(
					text = stringResource(id = R.string.title_second),
					style = MaterialTheme.typography.h2,
					color = white
				)
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
				.animateContentSize(
					animationSpec = spring(
						dampingRatio = Spring.DampingRatioLowBouncy,
						stiffness = Spring.StiffnessLow
					)
				)
		) {
			val numberText = when {
				pokemon.number < 10 -> stringResource(id = R.string.single_digit, pokemon.number)
				else -> pokemon.number.toString()
			}
			
			// POKEMON NUMBER
			Text(
				text = numberText,
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
						val tint = if (!expanded) inactive else accent_2
						Icon(
							painter = painterResource(id = icon),
							contentDescription = null,
							modifier = modifier.size(12.dp),
							tint = tint
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
				// POKEMON STATS
				PokemonStats(pokemon = pokemon)
				
				// POKEMON EXTRA INFO
				PokemonExtraInfo(pokemon = pokemon)
			}
		}
	}

}

/**
 * Composable to show the stats of each Pokemon
 * @param modifier [[Modifier]] Modifier for this composable
 * @param pokemon [[Pokemon]] Data Source for this Pokemon
 * */
@Composable
fun PokemonStats(
	modifier: Modifier = Modifier,
	pokemon: Pokemon
) {
	Column(
		modifier = modifier
			.fillMaxWidth()
			.padding(
				top = 18.dp,
				bottom = 8.dp,
			)
	) {
		Text(
			text = stringResource(id = R.string.stats),
			style = MaterialTheme.typography.h3,
			color = white,
			modifier = Modifier
				.padding(bottom = 16.dp)
		)

		Column(
			verticalArrangement = Arrangement.spacedBy(4.dp)
		) {
			// HP Progress Bar
			Row(
				horizontalArrangement = Arrangement.spacedBy(8.dp),
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.fillMaxWidth()
			) {
				Text(
					text = stringResource(id = R.string.hp),
					style = MaterialTheme.typography.h5,
					color = inactive
				)
				Text(
					text = stringResource(id = R.string.stats_percentage, pokemon.healthPower),
					style = MaterialTheme.typography.h5,
					color = accent_1
				)
				ProgressUI(UI = "HP", pokemon = pokemon)
			}

			// AP Progress Bar
			Row(
				horizontalArrangement = Arrangement.spacedBy(8.dp),
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.fillMaxWidth()
			) {
				Text(
					text = stringResource(id = R.string.ap),
					style = MaterialTheme.typography.h5,
					color = inactive
				)
				Text(
					text = stringResource(id = R.string.stats_percentage, pokemon.attackPower),
					style = MaterialTheme.typography.h5,
					color = accent_1
				)
				ProgressUI(UI = "AP", pokemon = pokemon)
			}

			// DF Progress Bar
			Row(
				horizontalArrangement = Arrangement.spacedBy(8.dp),
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.fillMaxWidth()
			) {
				Text(
					text = stringResource(id = R.string.df),
					style = MaterialTheme.typography.h5,
					color = inactive
				)
				Text(
					text = stringResource(id = R.string.stats_percentage, pokemon.defensePower),
					style = MaterialTheme.typography.h5,
					color = accent_3
				)
				ProgressUI(UI = "DF", pokemon = pokemon)
			}
		}

	}

}

@Composable
private fun ProgressUI(
	modifier: Modifier = Modifier,
	UI: String,
	pokemon: Pokemon
) {
	val barColor = when (UI) {
		"HP" -> accent_1
		"AP" -> accent_2
		else -> accent_3
	}

	val progressNum = when(UI) {
		"HP" -> pokemon.healthPower.toFloat() / 100
		"AP" -> pokemon.attackPower.toFloat() / 100
		else -> pokemon.defensePower.toFloat() / 100
	}

	val progressAnimation by animateFloatAsState(
		targetValue = progressNum,
		animationSpec = tween(900),
		visibilityThreshold = 0.001f
	)

	LinearProgressIndicator(
		color = barColor,
		backgroundColor = Color(0xFF151518),
		progress = progressAnimation,
		modifier = Modifier
			.fillMaxWidth()
	)
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
				text = type.uppercase(),
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