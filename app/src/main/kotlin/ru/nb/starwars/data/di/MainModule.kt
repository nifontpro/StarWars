package ru.nb.starwars.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

	@Provides
	@Singleton
	fun provideHttpClient(): HttpClient {
		return HttpClient(Android) {
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
}