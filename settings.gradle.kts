pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "8.2.1"
        id("org.jetbrains.kotlin.android") version "2.1.0" // or 1.9.x to match libs
        id("com.google.gms.google-services") version "4.4.0" // example — choose compatible version
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
