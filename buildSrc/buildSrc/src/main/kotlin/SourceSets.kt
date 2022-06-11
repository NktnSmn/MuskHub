object SourceSets {
    val kotlinSrc = "src/main/kotlin"
    val testSrc = "src/test/kotlin"
}

object AppConfig {
    val id = "nktn.smn.muskhub"
    val compileSdkVersion = 31
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