// settings.gradle.kts

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    // Choose FAIL_ON_PROJECT_REPOS to force using settings repositories only
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        // Add jitpack if you really need it:
        maven("https://jitpack.io")
    }
}

rootProject.name = "analikastore-android"
include(":app")
