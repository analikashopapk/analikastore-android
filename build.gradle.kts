plugins {
    // Android Gradle Plugin (AGP)
    id("com.android.application") version "8.2.1" apply false

    // Kotlin Android
    kotlin("android") version "1.9.10" apply false

    // Google Services plugin (Firebase, etc.)
    id("com.google.gms.google-services") version "4.4.0" apply false
}
buildscript {
    // empty — we prefer pluginManagement via settings.gradle.kts if present
}
