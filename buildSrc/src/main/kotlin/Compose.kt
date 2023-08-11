object Compose {
	const val composeVersion = "1.4.0"
	const val composeCompilerVersion = "1.4.6"

	private const val bomVersion = "2023.03.00"
	const val bom = "androidx.compose:compose-bom:$bomVersion"

	//    const val material = "androidx.compose.material:material:$composeVersion"
	const val material3 = "androidx.compose.material3:material3"
	const val ui = "androidx.compose.ui:ui"
	const val uiGraphics = "androidx.compose.ui:ui-graphics"
	const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
	const val materialIcon = "androidx.compose.material:material-icons-extended"

	private const val hiltNavigationComposeVersion = "1.0.0"
	const val hiltNavigationCompose =
		"androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

	private const val activityComposeVersion = "1.7.2"
	const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

	private const val lifecycleVersion = "2.6.1"
	const val viewModelCompose = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"

	private const val coilVersion = "2.2.2"
	const val coilCompose = "io.coil-kt:coil-compose:$coilVersion"

//	private const val permissionVersion = "0.26.2-beta"
//	const val permission = "com.google.accompanist:accompanist-permissions:$permissionVersion"
//
//	private const val splashVersion = "1.0.1"
//	const val splashScreen = "androidx.core:core-splashscreen:$splashVersion"
}
