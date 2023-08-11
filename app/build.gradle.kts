plugins {
	id("com.android.application")
	kotlin("android")
	kotlin("plugin.serialization")
}

android {
	namespace = ProjectConfig.appId
	compileSdk = ProjectConfig.compileSdk

	defaultConfig {
		applicationId = ProjectConfig.appId
		minSdk = ProjectConfig.minSdk
		targetSdk = ProjectConfig.targetSdk
		versionCode = ProjectConfig.versionCode
		versionName = ProjectConfig.versionName

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8

//		sourceCompatibility = JavaVersion.VERSION_17
//		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = "1.8"
//		jvmTarget = "17"
	}

	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KaptGenerateStubs> {
//	kotlinOptions {
//		jvmTarget = "1.8"
//	}
//}

dependencies {

	implementation(AndroidX.coreKtx)
	implementation(AndroidX.appCompat)
	implementation(Compose.activityCompose)

	implementation(platform(Compose.bom))
	implementation(Compose.ui)
	implementation(Compose.uiGraphics)
	implementation(Compose.uiToolingPreview)
	implementation(Compose.material3)
	implementation(Compose.materialIcon)
	implementation(Compose.viewModelCompose)
	implementation(Compose.navigation)

	implementation(Coin.compose)

	implementation(Kotlin.serialization)
	implementation(KTor.core)
	implementation(KTor.cio)
	implementation(KTor.logging)

	testImplementation(Testing.junit4)
	androidTestImplementation(Testing.junitAndroidExt)
	androidTestImplementation(Testing.espresso)

	androidTestImplementation(platform(Compose.bom))
	androidTestImplementation(Testing.composeUiTest)
	debugImplementation(Testing.uiTooling)
	debugImplementation(Testing.manifest)
}