pluginManagement {
	repositories {
		google()
		mavenCentral()
		gradlePluginPortal()
	}
}
dependencyResolutionManagement {
	repositories {
		google()
		mavenCentral()
	}
}

rootProject.name = "Star Wars"
include(":app")

include(":search")
include(":search:search_data")
include(":search:search_domain")
include(":search:search_presenter")

include(":favorite")
include(":favorite:favorite_data")
include(":favorite:favorite_domain")
include(":favorite:favorite_presenter")

