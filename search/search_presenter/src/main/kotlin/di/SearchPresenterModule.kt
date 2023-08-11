package di

import SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchPresenterModule = module {

	viewModel {
		SearchViewModel(
			peopleRepository = get(),
			starshipRepository = get(),
		)
	}

}