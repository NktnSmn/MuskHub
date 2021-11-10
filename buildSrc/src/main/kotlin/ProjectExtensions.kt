import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec

fun PluginDependenciesSpec.addDependencyUpdatedPlugin() {
    id(Deps.dependencyUpdatesPlugin) version Versions.dependencyUpdatesPlugin
}

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
    implementation(Deps.appCompat)
    implementation(Deps.constraintLayout)
}

@Suppress("UnstableApiUsage")
fun Project.applyComposeConfig() {
    android.run {
        buildFeatures.compose = true
        composeOptions {
            kotlinCompilerExtensionVersion = Versions.compose
        }
    }
    dependencies {
        implementation(Deps.composeCompiler)
        implementation(Deps.composeUi)
        implementation(Deps.composeUiTooling)
        implementation(Deps.composeUiFoundation)
        implementation(Deps.composeMaterial)
    }
}

private val Project.android: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension
        ?: error("Project '$name' is not an Android module")

private fun DependencyHandlerScope.implementation(dependencyNotation: Any) {
    "implementation"(dependencyNotation)
}