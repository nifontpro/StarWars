package repo

import model.BaseResult
import model.Starship

interface StarshipRepository {
	suspend fun search(searchText: String): BaseResult<Starship>
}