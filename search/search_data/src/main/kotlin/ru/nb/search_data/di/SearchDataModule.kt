package ru.nb.search_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.ktor.client.HttpClient
import ru.nb.search_data.repo.FilmRepositoryImpl
import ru.nb.search_data.repo.PeopleRepositoryImpl
import ru.nb.search_data.repo.PlanetRepositoryImpl
import ru.nb.search_data.repo.StarshipRepositoryImpl
import ru.nb.search_domain.repo.FilmRepository
import ru.nb.search_domain.repo.PeopleRepository
import ru.nb.search_domain.repo.PlanetRepository
import ru.nb.search_domain.repo.StarshipRepository

@Module
@InstallIn(ViewModelComponent::class)
object SearchDataModule {

	@Provides
	@ViewModelScoped
	fun providePeopleRepository(httpClient: HttpClient): PeopleRepository {
		return PeopleRepositoryImpl(httpClient)
	}

	@Provides
	@ViewModelScoped
	fun provideStarshipRepository(httpClient: HttpClient): StarshipRepository {
		return StarshipRepositoryImpl(httpClient)
	}

	@Provides
	@ViewModelScoped
	fun providePlanetRepository(httpClient: HttpClient): PlanetRepository {
		return PlanetRepositoryImpl(httpClient)
	}

	@Provides
	@ViewModelScoped
	fun provideFilmRepository(httpClient: HttpClient): FilmRepository {
		return FilmRepositoryImpl(httpClient)
	}

}