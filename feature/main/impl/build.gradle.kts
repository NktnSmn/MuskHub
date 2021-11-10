plugins {
    id("base-feature")
}
dependencies {
    api(project(Modules.mainApi))
    implementation(project(Modules.ui))

    requiredAndroidDeps()
}