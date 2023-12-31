package ru.nb.starwars.navigate

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Grade
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import ru.nb.starwars.R
import ru.nb.starwars.tags.TestTags

data class BottomNavigationItem(
	val title: String,
	val route: String,
	val selectedIcon: ImageVector,
	val unselectedIcon: ImageVector,
	val testTag: String = ""
)

@Composable
fun BottomBar(
	onItemClick: (String) -> Unit,
	isSelectItem: (String) -> Boolean,
) {

	val menuHome = stringResource(R.string.menu_home)
	val menuFavorite = stringResource(R.string.menu_favorite)
	val menuAbout = stringResource(R.string.about)
	val items = remember {
		listOf(
			BottomNavigationItem(
				title = menuHome,
				route = Screen.SearchScreen.route,
				selectedIcon = Icons.Filled.Home,
				unselectedIcon = Icons.Outlined.Home,
			),
			BottomNavigationItem(
				title = menuFavorite,
				route = Screen.FavoriteScreen.route,
				selectedIcon = Icons.Filled.Star,
				unselectedIcon = Icons.Outlined.Grade,
			),
			BottomNavigationItem(
				title = menuAbout,
				route = Screen.AboutScreen.route,
				selectedIcon = Icons.Filled.AccountBox,
				unselectedIcon = Icons.Outlined.AccountBox,
				testTag = TestTags.ABOUT_MENU_ITEM
			),
		)
	}

	NavigationBar {
		items.forEach { item ->
			val selected = isSelectItem(item.route)
			NavigationBarItem(
				modifier = Modifier.testTag(item.testTag),
				selected = selected,
				onClick = {
					onItemClick(item.route)
				},
				label = {
					Text(text = item.title)
				},
				alwaysShowLabel = false,
				icon = {
					Icon(
						imageVector = if (selected) {
							item.selectedIcon
						} else item.unselectedIcon,
						contentDescription = item.title
					)
				}
			)
		}
	}
}
