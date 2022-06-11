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
    implementation(Google.android.material)

    testImplementation(Testing.robolectric)
    testImplementation(Testing.mockK)
    testImplementation(Koin.test)
}