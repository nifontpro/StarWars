package ru.nb.favorite_data.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import ru.nb.favorite_data.db.StarwarDatabase
import ru.nb.favorite_domain.repo.FavoriteRepository
import ru.nb.favorite_data.repo.FavoriteRepositoryImpl
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
			.fallbackToDestructiveMigration()
			.build()
	}
}

@Module
@InstallIn(ViewModelComponent::class)
object FavoriteDataModule {
	@Provides
	@ViewModelScoped
	fun provideFavoriteRepository(db: StarwarDatabase): FavoriteRepository {
		return FavoriteRepositoryImpl(
			peopleDao = db.peopleDao,
			starshipDao = db.starshipDao,
			planetDao = db.planetDao
		)
	}
}