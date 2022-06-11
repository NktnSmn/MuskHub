plugins {
    id("base-library")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
}
applyComposeConfig()
dependencies {
    api(KotlinX.serialization.json)

    api(AndroidX.constraintLayout.compose)
    api(COIL.compose)
}