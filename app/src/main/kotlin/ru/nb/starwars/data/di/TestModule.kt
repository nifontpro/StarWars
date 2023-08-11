package ru.nb.starwars.data.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
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
		HttpClient(Android) {
			install(Logging) {
				level = LogLevel.ALL
			}

			install(DefaultRequest)

			install(ContentNegotiation) {
				json(Json {
					isLenient = true
					ignoreUnknownKeys = true
					prettyPrint = true
				})
			}

			install(HttpTimeout) {
				connectTimeoutMillis = 15000
				requestTimeoutMillis = 30000
			}
		}
	}

	viewModel { SearchViewModel(string = get(), peopleRepository = get()) }

}