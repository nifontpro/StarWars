package ru.nb.starwars

import android.app.Application
import di.favoriteDataModule
import di.searchDataModule
import di.searchPresenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.nb.starwars.data.di.mainModule

class MainApplication : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidLogger()
			androidContext(androidContext = this@MainApplication)

			modules(
				mainModule,
				searchPresenterModule,
				searchDataModule,
				favoriteDataModule,
			)

		}
	}

}