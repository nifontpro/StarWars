plugins {
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
}

android {
	namespace = "ru.nb.starwars"
	compileSdk = 33

	defaultConfig {
		applicationId = "ru.nb.starwars"
		minSdk = 24
		targetSdk = 33
		versionCode = 1
		versionName = "1.0"

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
	}
	kotlinOptions {
		jvmTarget = "1.8"
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

dependencies {

	implementation(AndroidX.coreKtx)
	implementation(Compose.viewModelCompose)
	implementation(Compose.activityCompose)

	implementation(platform(Compose.bom))
	implementation(Compose.ui)
	implementation(Compose.uiGraphics)
	implementation(Compose.uiToolingPreview)
	implementation(Compose.material3)
	implementation(Compose.materialIcon)

	testImplementation(Testing.junit4)
	androidTestImplementation(Testing.junitAndroidExt)
	androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

	androidTestImplementation(platform(Compose.bom))
	androidTestImplementation("androidx.compose.ui:ui-test-junit4")
	debugImplementation("androidx.compose.ui:ui-tooling")
	debugImplementation("androidx.compose.ui:ui-test-manifest")
}