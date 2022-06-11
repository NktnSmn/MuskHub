plugins {
    id("base-feature")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
}
applyComposeConfig()
dependencies {
    api(project(Modules.onboardingApi))
    implementation(project(Modules.ui))
    implementation(project(Modules.composableSDUI))

    implementation(KotlinX.serialization.json)

    implementation(Google.android.material)
    implementation(AndroidX.viewPager2)
    implementation(AndroidX.compose.material)
    implementation(AndroidX.constraintLayout.compose)
    implementation(COIL.compose)
}