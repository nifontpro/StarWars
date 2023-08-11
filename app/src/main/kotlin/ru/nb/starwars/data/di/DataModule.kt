package ru.nb.starwars.data.di

//@Module
//@InstallIn(SingletonComponent::class)
//object DataModule {
//
//	@Provides
//	@Singleton
//	fun provideHttpClient(): HttpClient {
//		return HttpClient(CIO) {
//			install(Logging) {
//				logger = Logger.SIMPLE
//				level = LogLevel.ALL
//			}
//
//			install(DefaultRequest)
//		}
//	}
//
//	@Provides
//	@Singleton
//	fun providePeopleRepository(httpClient: HttpClient): PeopleRepositoryImpl {
//		return PeopleRepositoryImpl(httpClient)
//	}
//
//}