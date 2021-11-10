plugins {
    id("com.android.application")
    id("kotlin-android")
}
applyAndroidConfig {
    defaultConfig {
        applicationId = AppConfig.id
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}
dependencies {
    (Modules.allShared + Modules.allFeaturesImpl).forEach { implementation(project(it)) }

    requiredAndroidDeps()
    implementation(Deps.material)

    testImplementation(Deps.robolectric)
    testImplementation(Deps.mockk)
    testImplementation(Deps.koinTest)
}