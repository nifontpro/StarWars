package ru.nb.starwars.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nb.favorite_data.db.StarwarDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

	@Provides
	@Singleton
	fun provideNoteDatabase(app: Application): StarwarDatabase {
		return Room.inMemoryDatabaseBuilder(
			app,
			StarwarDatabase::class.java,
		).build()
	}

}