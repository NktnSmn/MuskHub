import com.android.build.gradle.BaseExtension
import de.fayard.refreshVersions.core.versionFor
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies

fun Project.applyAndroidConfig(configExtensions: (BaseExtension.() -> Unit)? = null) {
    android.run {
        compileSdkVersion(AppConfig.compileSdkVersion)
        defaultConfig {
            minSdk = AppConfig.minSdkVersion
            targetSdk = AppConfig.targetSdkVersion
            versionCode = AppConfig.versionCode
            versionName = AppConfig.versionName
        }
        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            }
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
        sourceSets {
            getByName("main").java.srcDirs(SourceSets.kotlinSrc)
            getByName("test").java.srcDirs(SourceSets.testSrc)
        }
        configExtensions?.invoke(this)
    }
}

fun DependencyHandlerScope.requiredAndroidDeps() {
    implementation(AndroidX.appCompat)
    implementation(AndroidX.constraintLayout)
}

@Suppress("UnstableApiUsage")
fun Project.applyComposeConfig() {
    android.run {
        buildFeatures.compose = true
        composeOptions {
            kotlinCompilerExtensionVersion = versionFor(AndroidX.compose.compiler)
        }
    }
    dependencies {
        implementation(AndroidX.compose.compiler)
        implementation(AndroidX.compose.ui)
        implementation(AndroidX.compose.ui.tooling)
        implementation(AndroidX.compose.foundation)
        implementation(AndroidX.constraintLayout.compose)
    }
}

private val Project.android: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension
        ?: error("Project '$name' is not an Android module")

private fun DependencyHandlerScope.implementation(dependencyNotation: Any) {
    "implementation"(dependencyNotation)
}