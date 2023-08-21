package ru.nb.starwars

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import app.cash.turbine.test
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ru.nb.favorite_data.di.DbDataModule
import ru.nb.favorite_domain.repo.FavoriteRepository
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

	@Inject
	lateinit var favoriteRepository: FavoriteRepository

	@Before
	fun setUp() {
//		Dispatchers.setMain(StandardTestDispatcher())
		hiltRule.inject()
	}

	@After
	fun tearDown() {
//		Dispatchers.resetMain()
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

	@Test
	fun testRoomWithFlow() = runTest {
		val testPeople = People(
			name = "Test add people name",
			gender = "male",
			starshipsCount = 0,
			homeworld = "",
			filmsUrls = emptyList(),
			url = "https://swapi.dev/api/people/1/"
		)
		favoriteRepository.addPeople(testPeople)

		favoriteRepository.getAllPeoples().test {
			val favoritePeoples = awaitItem()
			assertEquals(testPeople, favoritePeoples.find { it == testPeople })
			cancelAndConsumeRemainingEvents()
		}
	}

}