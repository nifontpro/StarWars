package ru.nb.starwars.navigate

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.nb.favorite_presenter.FavoriteScreen
import ru.nb.search_presenter.SearchScreen
import ru.nb.starwars.R

@Composable
fun Navigate() {
	val navController = rememberNavController()

	NavHost(
		navController = navController,
		startDestination = Screen.MainScreen.route
	) {
		composable(Screen.MainScreen.route) {
			ConfigureBottomNavigate()
		}

		composable(
			"one",
//				arguments = listOf(navArgument(Argument.personId)),
		) {
			Text("Screen one")
		}

		composable(
			"two"
//				arguments = listOf(
//					navArgument(Argument.personId), navArgument(Argument.eventId)
//				),
		) {
			Text("Screen two")
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ConfigureBottomNavigate() {
	val navController = rememberNavController()
	val backStackEntry = navController.currentBackStackEntryAsState()
	Scaffold(
		bottomBar = {
			BottomBar(
				onItemClick = { route ->
					navController.navigate(route) {
						navController.graph.startDestinationRoute?.let { route ->
							popUpTo(route) {
								saveState = true
							}
						}
						launchSingleTop = true
						restoreState = true
					}
				},
				isSelectItem = { route ->
					route == backStackEntry.value?.destination?.route
				}
			)
		}
	) { paddingValues ->
		NavHost(
			navController = navController,
			startDestination = Screen.SearchScreen.route
		) {

			composable(Screen.SearchScreen.route) {
				SearchScreen(paddingValues)
			}
			composable(Screen.FavoriteScreen.route) {
				FavoriteScreen(paddingValues)
			}
			composable(Screen.AboutScreen.route) {
				Box(
					modifier = Modifier
						.padding(paddingValues)
						.fillMaxSize()
				) {
					Column(modifier = Modifier.fillMaxWidth()) {
						Text(
							text = "Star Wars by Dmitry Busygin",
							modifier = Modifier.align(Alignment.CenterHorizontally)
						)
					}

					Icon(
						imageVector = ImageVector.vectorResource(R.drawable.jedi),
						contentDescription = "",
						modifier = Modifier
							.align(Alignment.Center)
							.size(300.dp),
						tint = MaterialTheme.colorScheme.tertiary
					)

					BottomIcon(iconSize = 64.dp)
				}
			}
		}
	}
}

@Composable
private fun BoxScope.BottomIcon(iconSize: Dp) {

	Row(
		modifier = Modifier
			.align(Alignment.BottomCenter)
			.fillMaxWidth()
			.padding(bottom = 80.dp)
			.padding(horizontal = 80.dp),
		horizontalArrangement = Arrangement.SpaceBetween,
	) {
		Image(
			imageVector = ImageVector.vectorResource(R.drawable.ic_kotlin_icon),
			contentDescription = "",
			modifier = Modifier
				.size(iconSize)
		)
		Image(
			imageVector = ImageVector.vectorResource(R.drawable.ic_compose),
			contentDescription = "",
			modifier = Modifier
				.size(iconSize)
		)
	}
}