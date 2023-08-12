package ru.nb.search_data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.ktor.client.HttpClient;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.nb.search_domain.repo.StarshipRepository;

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
public final class SearchDataModule_ProvideStarshipRepositoryFactory implements Factory<StarshipRepository> {
  private final Provider<HttpClient> httpClientProvider;

  public SearchDataModule_ProvideStarshipRepositoryFactory(
      Provider<HttpClient> httpClientProvider) {
    this.httpClientProvider = httpClientProvider;
  }

  @Override
  public StarshipRepository get() {
    return provideStarshipRepository(httpClientProvider.get());
  }

  public static SearchDataModule_ProvideStarshipRepositoryFactory create(
      Provider<HttpClient> httpClientProvider) {
    return new SearchDataModule_ProvideStarshipRepositoryFactory(httpClientProvider);
  }

  public static StarshipRepository provideStarshipRepository(HttpClient httpClient) {
    return Preconditions.checkNotNullFromProvides(SearchDataModule.INSTANCE.provideStarshipRepository(httpClient));
  }
}
