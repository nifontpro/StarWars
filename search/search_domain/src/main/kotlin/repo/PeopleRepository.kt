package repo

import model.BaseResult
import model.People

interface PeopleRepository {
	suspend fun getPeople(): BaseResult<People>
	suspend fun search(searchText: String): BaseResult<People>
	suspend fun getNext(url: String): BaseResult<People>
}