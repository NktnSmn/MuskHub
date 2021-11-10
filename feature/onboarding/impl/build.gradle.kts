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

    implementation(Deps.kotlinSerialization)

    implementation(Deps.material)
    implementation(Deps.viewPager)
    implementation(Deps.composeConstraintLayout)
    implementation(Deps.coilCompose)
}