package ru.nb.favorite_data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.nb.favorite_data.db.StarwarDatabase;
import ru.nb.favorite_domain.repo.FavoriteRepository;

@ScopeMetadata("dagger.hilt.android.scopes.ViewModelScoped")
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

  public FavoriteDataModule_ProvideFavoriteRepositoryFactory(Provider<StarwarDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public FavoriteRepository get() {
    return provideFavoriteRepository(dbProvider.get());
  }

  public static FavoriteDataModule_ProvideFavoriteRepositoryFactory create(
      Provider<StarwarDatabase> dbProvider) {
    return new FavoriteDataModule_ProvideFavoriteRepositoryFactory(dbProvider);
  }

  public static FavoriteRepository provideFavoriteRepository(StarwarDatabase db) {
    return Preconditions.checkNotNullFromProvides(FavoriteDataModule.INSTANCE.provideFavoriteRepository(db));
  }
}
