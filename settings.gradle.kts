pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    // prefer central repositories defined here; disallow project-level repos
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        // optional additional repo
        maven("https://jitpack.io")
    }
}

rootProject.name = "analikastore-android"
include(":app")
