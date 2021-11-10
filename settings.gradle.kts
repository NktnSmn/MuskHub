@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MuskHub"
rootDir
    .walk()
    .filter { it.name in arrayOf("app", "feature", "shared") }
    .forEach { modulesRootDir ->
        modulesRootDir
            .walk()
            .maxDepth(2)
            .filter { file("${it.absolutePath}\\build.gradle.kts").exists() }
            .forEach {
                val moduleName = StringBuilder()
                var moduleDir: File = it
                do {
                    moduleName.insert(0, ":${moduleDir.name}")
                    moduleDir = moduleDir.parentFile
                } while (moduleDir != rootDir)
                include(moduleName.toString())
            }
    }