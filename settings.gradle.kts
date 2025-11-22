// settings.gradle.kts
pluginManagement {
    repositories {
        // plugin resolution repositories (order matters)
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    // Declare plugin versions here so module build files can use plugins { id(...) } without a version
    plugins {
        // use AGP version compatible with your Gradle; adjust version if you need a different AGP
        id("com.android.application") version "8.2.0" apply false
        id("com.android.library")     version "8.2.0" apply false
        id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "analikastore-android"
include(":app")
