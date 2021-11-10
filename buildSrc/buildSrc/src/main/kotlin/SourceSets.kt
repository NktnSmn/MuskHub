object Versions {
    val gradleBuildTools = "7.0.3"
    val dependencyUpdatesPlugin = "0.39.0"
    val kotlin = "1.5.31"
    val koin = "3.1.3"
    val compose = "1.0.5"
}

object SourceSets {
    val kotlinSrc = "src/main/kotlin"
    val testSrc = "src/test/kotlin"
}

object AppConfig {
    val id = "nktn.smn.muskhub"
    val compileSdkVersion = 30
    val minSdkVersion = 21
    val targetSdkVersion = 30
    val versionCode = 1
    val versionName = "1.0"
}

object Modules {
    val feature = ":shared:feature"
    val ui = ":shared:ui"
    val composableSDUI = ":shared:composable_sdui"

    val settingsActivityApi = ":feature:settings:api"
    val settingsActivityImpl = ":feature:settings:impl"
    val launchesApi = ":feature:launches:api"
    val launchesImpl = ":feature:launches:impl"
    val mainApi = ":feature:main:api"
    val mainImpl = ":feature:main:impl"
    val onboardingApi = ":feature:onboarding:api"
    val onboardingImpl = ":feature:onboarding:impl"

    val allShared: Array<String> =
        arrayOf(
            feature,
            ui,
            composableSDUI
        )
    val allFeaturesImpl: Array<String> =
        arrayOf(
            settingsActivityImpl,
            launchesImpl,
            mainImpl,
            onboardingImpl
        )
}

object Deps {
    val gradleBuildToolsApi = "com.android.tools.build:gradle-api:${Versions.gradleBuildTools}"
    val gradleBuildTools = "com.android.tools.build:gradle:${Versions.gradleBuildTools}"

    val dependencyUpdatesPlugin = "com.github.ben-manes.versions"

    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlinSerializationClasspath = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val kotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0"

    val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.1"
    val appCompat = "androidx.appcompat:appcompat:1.3.1"
    val material = "com.google.android.material:material:1.4.0"
    val viewPager = "androidx.viewpager2:viewpager2:1.0.0"

    val koin = "io.insert-koin:koin-android:${Versions.koin}"

    val koinTest = "io.insert-koin:koin-test:${Versions.koin}"
    val robolectric = "org.robolectric:robolectric:4.6.1"
    val mockk = "io.mockk:mockk:1.12.0"

    val composeCompiler = "androidx.compose.compiler:compiler:${Versions.compose}"
    val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    val composeUiFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    val composeConstraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0-rc01"

    val coilCompose = "io.coil-kt:coil-compose:1.4.0"
}