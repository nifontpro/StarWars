package di

import org.koin.dsl.module
import repo.PeopleRepository
import repo.PeopleRepositoryImpl
import repo.StarshipRepository
import repo.StarshipRepositoryImpl

val searchDataModule = module {

	single<PeopleRepository> { PeopleRepositoryImpl(httpClient = get()) }

	single<StarshipRepository> { StarshipRepositoryImpl(httpClient = get()) }

}