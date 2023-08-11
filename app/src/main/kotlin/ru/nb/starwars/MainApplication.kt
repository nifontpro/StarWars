package ru.nb.starwars

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.nb.starwars.data.di.testModule

class MainApplication : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidLogger()
			androidContext(this@MainApplication)
			modules(testModule)
		}
	}

}