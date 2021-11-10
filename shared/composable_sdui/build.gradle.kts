plugins {
    id("base-library")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
}
applyComposeConfig()
dependencies {
    api(Deps.kotlinSerialization)

    api(Deps.composeConstraintLayout)
    api(Deps.coilCompose)
}