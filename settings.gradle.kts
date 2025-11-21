pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        // pick versions compatible with your Android Gradle Plugin and Kotlin libs
        id("com.android.application") version "8.2.1"
        id("org.jetbrains.kotlin.android") version "2.1.0" // or 1.9.x depending on your kotlin libs
        id("com.google.gms.google-services") version "4.4.0" // example
       
    }
plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
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
