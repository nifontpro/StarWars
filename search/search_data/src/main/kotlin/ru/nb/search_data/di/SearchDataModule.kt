package ru.nb.search_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import ru.nb.search_data.repo.PeopleRepositoryImpl
import ru.nb.search_data.repo.PlanetRepositoryImpl
import ru.nb.search_data.repo.StarshipRepositoryImpl
import ru.nb.search_domain.repo.PeopleRepository
import ru.nb.search_domain.repo.PlanetRepository
import ru.nb.search_domain.repo.StarshipRepository
import javax.inject.Singleton

@Module
//@InstallIn(ViewModelComponent::class) // Не подходит для тестирования
@InstallIn(SingletonComponent::class)
object SearchDataModule {

	@Provides
//	@ViewModelScoped
	@Singleton
	fun providePeopleRepository(httpClient: HttpClient): PeopleRepository {
		return PeopleRepositoryImpl(httpClient)
	}

	@Provides
//	@ViewModelScoped
	@Singleton
	fun provideStarshipRepository(httpClient: HttpClient): StarshipRepository {
		return StarshipRepositoryImpl(httpClient)
	}

	@Provides
//	@ViewModelScoped
	@Singleton
	fun providePlanetRepository(httpClient: HttpClient): PlanetRepository {
		return PlanetRepositoryImpl(httpClient)
	}

}