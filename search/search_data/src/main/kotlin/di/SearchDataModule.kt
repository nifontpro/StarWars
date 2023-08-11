package di

import org.koin.dsl.module
import repo.PeopleRepository
import repo.PeopleRepositoryImpl

val searchDataModule = module {

	single<PeopleRepository> { PeopleRepositoryImpl(httpClient = get()) }

}