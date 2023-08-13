apply {
	from("$rootDir/compose-module.gradle")
}
//
//android {
//	namespace = ProjectConfig.appId
//}

dependencies {
//    "implementation"(project(Modules.core))
//    "implementation"(project(Modules.coreUi))

	"implementation" (project(Modules.searchDomain))
	"implementation" (project(Modules.favoriteDomain))

}