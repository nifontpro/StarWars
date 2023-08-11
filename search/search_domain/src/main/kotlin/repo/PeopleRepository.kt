package repo

import model.BaseResult
import model.People

interface PeopleRepository {
	suspend fun getPeople(): BaseResult<People>
}