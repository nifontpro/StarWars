package di

import androidx.room.Room
import db.StarwarDatabase
import db.dao.PeopleDao
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import repo.FavoriteRepository
import repo.FavoriteRepositoryImpl

val favoriteDataModule = module {

	single<StarwarDatabase> {
		Room.databaseBuilder(
			androidApplication(),
			StarwarDatabase::class.java,
			"starwar_db"
		)
			.fallbackToDestructiveMigration()
			.build()
	}

	single {
		val db = get<StarwarDatabase>()
		db.peopleDao
	}

	single<FavoriteRepository> {
		FavoriteRepositoryImpl(peopleDao = get())
	}

}