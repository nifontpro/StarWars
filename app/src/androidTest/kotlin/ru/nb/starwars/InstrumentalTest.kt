package ru.nb.starwars

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ru.nb.favorite_data.di.DbDataModule
import ru.nb.search_domain.model.People
import ru.nb.search_domain.repo.PeopleRepository
import ru.nb.starwars.tags.TestTags
import javax.inject.Inject

@HiltAndroidTest
@UninstallModules(DbDataModule::class) // Заменяем рабочую БД на тестовую в памяти
class InstrumentalTest {

	@get:Rule(order = 0)
	val hiltRule = HiltAndroidRule(this)

	@get: Rule(order = 1)
	val composeRule = createAndroidComposeRule<MainActivity>()

	@Inject
	lateinit var peopleRepository: PeopleRepository
//	lateinit var favoriteRepository: FavoriteRepository

	@Before
	fun setUp() {
		hiltRule.inject()
	}

	/**
	 * Простой инструментальный тест Compose
	 * Тестирование навигации до экрана "О программе"
	 */
	@Test
	fun clickAboutScreen_isVisible() {
		composeRule.onNodeWithTag(TestTags.ABOUT_SECTION).assertDoesNotExist()
		composeRule.onNodeWithTag(TestTags.ABOUT_MENU_ITEM).performClick()
		composeRule.onNodeWithTag(TestTags.ABOUT_SECTION).assertIsDisplayed()
	}

	/**
	 * Проверка поискового запроса в сеть
	 */
	@Test
	fun testSearchPeople() {
		runTest {
			val testPeople = People(
				name = "Leia Organa",
				gender = "female",
				starshipsCount = 0,
				homeworld = "",
				filmsUrls = emptyList(),
				url = "https://swapi.dev/api/people/5/"
			)
			val peoples = peopleRepository.search("na").data
			val findPeople = peoples.find { people ->
				people.name == testPeople.name &&
						people.gender == testPeople.gender &&
						people.url == testPeople.url
			}
			assertEquals(true, findPeople != null)
		}
	}

}