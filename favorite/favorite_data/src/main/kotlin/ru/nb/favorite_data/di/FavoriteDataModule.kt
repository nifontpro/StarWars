package ru.nb.favorite_data.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import ru.nb.favorite_data.db.StarwarDatabase
import ru.nb.favorite_data.repo.FavoriteRepositoryImpl
import ru.nb.favorite_domain.repo.FavoriteRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbDataModule {

	@Provides
	@Singleton
	fun provideDataBase(app: Application): StarwarDatabase {
		return Room.databaseBuilder(
			app,
			StarwarDatabase::class.java,
			"starwar_db"
		)
//			.fallbackToDestructiveMigration()
			.build()
	}
}

@Module
//@InstallIn(ViewModelComponent::class)
@InstallIn(SingletonComponent::class) // for test
object FavoriteDataModule {

	@Provides
	@Singleton
//	@ViewModelScoped
	fun provideFavoriteRepository(db: StarwarDatabase, httpClient: HttpClient): FavoriteRepository {
		return FavoriteRepositoryImpl(
			httpClient = httpClient,
			peopleDao = db.peopleDao,
			starshipDao = db.starshipDao,
			planetDao = db.planetDao,
			filmDao = db.filmDao,
			peopleWithFilmDao = db.peopleWithFilmDao
		)
	}
}