apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation" (project(Modules.searchDomain))

    "implementation" (Kotlin.serialization)
    "implementation" (KTor.core)
 }
