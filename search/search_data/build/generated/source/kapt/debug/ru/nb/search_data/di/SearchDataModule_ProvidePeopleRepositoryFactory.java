package ru.nb.search_data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.ktor.client.HttpClient;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.nb.search_domain.repo.PeopleRepository;

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
public final class SearchDataModule_ProvidePeopleRepositoryFactory implements Factory<PeopleRepository> {
  private final Provider<HttpClient> httpClientProvider;

  public SearchDataModule_ProvidePeopleRepositoryFactory(Provider<HttpClient> httpClientProvider) {
    this.httpClientProvider = httpClientProvider;
  }

  @Override
  public PeopleRepository get() {
    return providePeopleRepository(httpClientProvider.get());
  }

  public static SearchDataModule_ProvidePeopleRepositoryFactory create(
      Provider<HttpClient> httpClientProvider) {
    return new SearchDataModule_ProvidePeopleRepositoryFactory(httpClientProvider);
  }

  public static PeopleRepository providePeopleRepository(HttpClient httpClient) {
    return Preconditions.checkNotNullFromProvides(SearchDataModule.INSTANCE.providePeopleRepository(httpClient));
  }
}
