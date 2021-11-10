buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Deps.gradleBuildTools)
        classpath(Deps.kotlinGradlePlugin)
        classpath(Deps.kotlinSerializationClasspath)
    }
}

plugins {
    addDependencyUpdatedPlugin()
}

tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version) && !isNonStable(currentVersion)
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks.create<Delete>("clean") {
    delete(rootProject.buildDir)
}