// settings.gradle.kts - replace your current file with this exact content

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    // Optional: declare plugin versions here if you want centralized plugin versions.
}

dependencyResolutionManagement {
    // Prefer repositories declared here (in settings) over repositories declared in build scripts
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        // add others only if required, e.g. maven("https://jitpack.io")
    }
}

rootProject.name = "analikastore-android"
include(":app")
