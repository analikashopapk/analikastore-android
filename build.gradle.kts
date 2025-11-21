plugins {
    // Android Gradle Plugin (AGP)
    id("com.android.application") version "8.2.1" apply false

    // Kotlin Android
    kotlin("android") version "1.9.10" apply false

    // Google Services plugin (Firebase, etc.)
    id("com.google.gms.google-services") version "4.4.0" apply false

   // Make Kotlin 2.1.0 available to modules (do not apply here)
    id("org.jetbrains.kotlin.android") version "2.1.0" apply false

    // Make Android Gradle Plugin consistent (use an 8.2.x line compatible with Gradle 8.2)
    id("com.android.library") version "8.2.1" apply false
}
buildscript {
    // empty — we prefer pluginManagement via settings.gradle.kts if present
}
