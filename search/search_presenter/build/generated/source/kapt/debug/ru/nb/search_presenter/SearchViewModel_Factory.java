package ru.nb.search_presenter;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import ru.nb.favorite_domain.repo.FavoriteRepository;
import ru.nb.search_domain.repo.FilmRepository;
import ru.nb.search_domain.repo.PeopleRepository;
import ru.nb.search_domain.repo.PlanetRepository;
import ru.nb.search_domain.repo.StarshipRepository;

@ScopeMetadata
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
public final class SearchViewModel_Factory implements Factory<SearchViewModel> {
  private final Provider<PeopleRepository> peopleRepositoryProvider;

  private final Provider<StarshipRepository> starshipRepositoryProvider;

  private final Provider<PlanetRepository> planetRepositoryProvider;

  private final Provider<FilmRepository> filmRepositoryProvider;

  private final Provider<FavoriteRepository> favoriteRepositoryProvider;

  public SearchViewModel_Factory(Provider<PeopleRepository> peopleRepositoryProvider,
      Provider<StarshipRepository> starshipRepositoryProvider,
      Provider<PlanetRepository> planetRepositoryProvider,
      Provider<FilmRepository> filmRepositoryProvider,
      Provider<FavoriteRepository> favoriteRepositoryProvider) {
    this.peopleRepositoryProvider = peopleRepositoryProvider;
    this.starshipRepositoryProvider = starshipRepositoryProvider;
    this.planetRepositoryProvider = planetRepositoryProvider;
    this.filmRepositoryProvider = filmRepositoryProvider;
    this.favoriteRepositoryProvider = favoriteRepositoryProvider;
  }

  @Override
  public SearchViewModel get() {
    return newInstance(peopleRepositoryProvider.get(), starshipRepositoryProvider.get(), planetRepositoryProvider.get(), filmRepositoryProvider.get(), favoriteRepositoryProvider.get());
  }

  public static SearchViewModel_Factory create(Provider<PeopleRepository> peopleRepositoryProvider,
      Provider<StarshipRepository> starshipRepositoryProvider,
      Provider<PlanetRepository> planetRepositoryProvider,
      Provider<FilmRepository> filmRepositoryProvider,
      Provider<FavoriteRepository> favoriteRepositoryProvider) {
    return new SearchViewModel_Factory(peopleRepositoryProvider, starshipRepositoryProvider, planetRepositoryProvider, filmRepositoryProvider, favoriteRepositoryProvider);
  }

  public static SearchViewModel newInstance(PeopleRepository peopleRepository,
      StarshipRepository starshipRepository, PlanetRepository planetRepository,
      FilmRepository filmRepository, FavoriteRepository favoriteRepository) {
    return new SearchViewModel(peopleRepository, starshipRepository, planetRepository, filmRepository, favoriteRepository);
  }
}
