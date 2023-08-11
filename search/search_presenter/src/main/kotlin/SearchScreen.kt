import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen() {
	val viewModel = koinViewModel<SearchViewModel>()
	LazyColumn {
		items(viewModel.peoples) {people ->
			Text(text = people.name)
		}
	}
}