apply {
	from("$rootDir/compose-module.gradle")
}

dependencies {
	"implementation"(project(Modules.favoriteDomain))
	"implementation"(project(Modules.searchDomain))
}