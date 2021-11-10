plugins {
    id("base-feature")
}
dependencies {
    api(project(Modules.settingsActivityApi))
    implementation(project(Modules.ui))

    requiredAndroidDeps()
}