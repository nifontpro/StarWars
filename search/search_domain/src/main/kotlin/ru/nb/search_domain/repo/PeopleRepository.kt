package ru.nb.search_domain.repo

import ru.nb.search_domain.model.BaseResult
import ru.nb.search_domain.model.People

interface PeopleRepository {
	suspend fun search(searchText: String): BaseResult<People>
}