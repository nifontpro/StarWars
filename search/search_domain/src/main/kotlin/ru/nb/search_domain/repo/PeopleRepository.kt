package ru.nb.search_domain.repo

import ru.nb.search_domain.model.BaseResult
import ru.nb.search_domain.model.People

interface PeopleRepository {
	suspend fun getPeople(): BaseResult<People>
	suspend fun search(searchText: String): BaseResult<People>
	suspend fun getNext(url: String): BaseResult<People>
}