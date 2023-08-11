import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.RocketLaunch
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import model.People
import model.Starship
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
	val viewModel = koinViewModel<SearchViewModel>()
	Column(
		modifier = Modifier.fillMaxSize()
	) {
		var searchText by remember { mutableStateOf("") }
		LaunchedEffect(key1 = searchText) {
			if (searchText.isBlank() || searchText.length < 2) return@LaunchedEffect
			delay(1000)
			viewModel.findPeople(searchText)
		}

		OutlinedTextField(
			modifier = Modifier
				.padding(8.dp)
				.fillMaxWidth(),
			value = searchText,
			onValueChange = { searchText = it },
			placeholder = { Text("Search") },
			leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
			trailingIcon = {
				Icon(
					modifier = Modifier.clickable { searchText = "" },
					imageVector = Icons.Default.Close,
					contentDescription = "Cancel"
				)
			},
			singleLine = true
		)
		LazyColumn(
			verticalArrangement = Arrangement.spacedBy(8.dp)
		) {
			items(viewModel.baseUiList) { baseUi ->
				ElevatedCard(
					modifier = Modifier
						.padding(horizontal = 8.dp)
						.fillMaxWidth()
				) {
					Row(
						modifier = Modifier.padding(8.dp),
						verticalAlignment = Alignment.CenterVertically
					) {
						when (baseUi) {
							is People -> PeopleCard(people = baseUi)
							is Starship -> StarshipCard(starship = baseUi)
						}
					}
				}
			}
		}
	}
}

@Composable
private fun PeopleCard(people: People) {
	Icon(
		modifier = Modifier.padding(8.dp),
		imageVector = Icons.Outlined.Person,
		tint = MaterialTheme.colorScheme.primary,
		contentDescription = null
	)
	Column {
		Text(text = people.name)
		Text(text = people.gender)
		Text(text = "Starships: ${people.starshipsCount}")
	}
}

@Composable
private fun StarshipCard(starship: Starship) {
	Icon(
		modifier = Modifier.padding(8.dp),
		imageVector = Icons.Outlined.RocketLaunch,
		tint = MaterialTheme.colorScheme.primary,
		contentDescription = null
	)
	Column {
		Text(text = starship.name)
		Text(text = starship.model)
		Text(text = starship.passengers)
		Text(text = starship.manufacturer)
	}
}