object Testing {
	private const val junitVersion = "4.13.2"
	const val junit4 = "junit:junit:$junitVersion"

	private const val junitAndroidExtVersion = "1.1.5"
	const val junitAndroidExt = "androidx.test.ext:junit:$junitAndroidExtVersion"

	private const val coroutinesTestVersion = "1.6.4"
	const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion"

	const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Compose.composeVersion}"

	const val hiltTesting = "com.google.dagger:hilt-android-testing:${DaggerHilt.version}"

	private const val testRunnerVersion = "1.5.2"
	const val testRunner = "androidx.test:runner:$testRunnerVersion"
}