/*
 * settings.gradle.kts
 *
 * Declares plugin versions and repositories so module build files can use plugin IDs
 * with no versions (recommended when dependencyResolutionManagement is enabled).
 */

rootProject.name = "analikastore-android"

pluginManagement {
    // Repositories for plugin resolution (must include google() for AGP)
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    // Declare plugin versions here so modules can just use `id("...")`
    plugins {
        // Android Gradle Plugin version — pick one compatible with your Gradle wrapper.
        // For Gradle 8.2, AGP 8.2.x is appropriate. Use the exact version you want.
        id("com.android.application") version "8.2.0"
        id("com.android.library")     version "8.2.0" // if you have library modules
        id("org.jetbrains.kotlin.android") version "1.9.21"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

include(":app")
