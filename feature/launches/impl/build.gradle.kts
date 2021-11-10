plugins {
    id("base-feature")
}
dependencies {
    api(project(Modules.launchesApi))
    implementation(project(Modules.ui))

    requiredAndroidDeps()
}