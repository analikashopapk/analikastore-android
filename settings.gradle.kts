pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "8.2.0" apply false
        id("com.android.library")     version "8.2.0" apply false
        id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    }
}

dependencyResolutionManagement {
    // keep FAIL_ON_PROJECT_REPOS (recommended) and centralize repos here
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "analikastore-android"
include(":app")
