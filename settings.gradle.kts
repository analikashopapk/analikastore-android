// settings.gradle.kts

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    // Prevent repositories in project build files when you prefer settings repositories
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        // JitPack if you need it
        maven("https://jitpack.io")
    }
}

rootProject.name = "analikastore-android"
include(":app")
