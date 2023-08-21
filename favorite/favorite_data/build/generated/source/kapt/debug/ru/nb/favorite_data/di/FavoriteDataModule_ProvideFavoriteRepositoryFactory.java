package ru.nb.favorite_data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.ktor.client.HttpClient;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.nb.favorite_data.db.StarwarDatabase;
import ru.nb.favorite_domain.repo.FavoriteRepository;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class FavoriteDataModule_ProvideFavoriteRepositoryFactory implements Factory<FavoriteRepository> {
  private final Provider<StarwarDatabase> dbProvider;

  private final Provider<HttpClient> httpClientProvider;

  public FavoriteDataModule_ProvideFavoriteRepositoryFactory(Provider<StarwarDatabase> dbProvider,
      Provider<HttpClient> httpClientProvider) {
    this.dbProvider = dbProvider;
    this.httpClientProvider = httpClientProvider;
  }

  @Override
  public FavoriteRepository get() {
    return provideFavoriteRepository(dbProvider.get(), httpClientProvider.get());
  }

  public static FavoriteDataModule_ProvideFavoriteRepositoryFactory create(
      Provider<StarwarDatabase> dbProvider, Provider<HttpClient> httpClientProvider) {
    return new FavoriteDataModule_ProvideFavoriteRepositoryFactory(dbProvider, httpClientProvider);
  }

  public static FavoriteRepository provideFavoriteRepository(StarwarDatabase db,
      HttpClient httpClient) {
    return Preconditions.checkNotNullFromProvides(FavoriteDataModule.INSTANCE.provideFavoriteRepository(db, httpClient));
  }
}
