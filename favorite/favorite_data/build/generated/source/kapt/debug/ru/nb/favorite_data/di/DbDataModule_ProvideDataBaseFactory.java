package ru.nb.favorite_data.di;

import android.app.Application;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.nb.favorite_data.db.StarwarDatabase;

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
public final class DbDataModule_ProvideDataBaseFactory implements Factory<StarwarDatabase> {
  private final Provider<Application> appProvider;

  public DbDataModule_ProvideDataBaseFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public StarwarDatabase get() {
    return provideDataBase(appProvider.get());
  }

  public static DbDataModule_ProvideDataBaseFactory create(Provider<Application> appProvider) {
    return new DbDataModule_ProvideDataBaseFactory(appProvider);
  }

  public static StarwarDatabase provideDataBase(Application app) {
    return Preconditions.checkNotNullFromProvides(DbDataModule.INSTANCE.provideDataBase(app));
  }
}
