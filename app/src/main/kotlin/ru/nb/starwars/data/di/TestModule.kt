package ru.nb.starwars.data.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.nb.starwars.data.repo.PeopleRepositoryImpl
import ru.nb.starwars.search.SearchViewModel

val testModule = module {

	single {
		PeopleRepositoryImpl(httpClient = get())
	}

	single {
		"Test String"
	}

	single {
		HttpClient(CIO)
	}

	viewModel { SearchViewModel(string = get()) }

}