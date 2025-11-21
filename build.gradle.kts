plugins {
    // Keep AGP 8.1 (compatible with Gradle 8.1 used in CI)
    id("com.android.application") version "8.1.0" apply false

    // Kotlin plugin bumped to 1.9.10 to match library metadata
    kotlin("android") version "1.9.10" apply false

    // Google services (apply in app module if needed)
    id("com.google.gms.google-services") version "4.3.15" apply false
}

buildscript {
    // empty — we prefer pluginManagement via settings.gradle.kts if present
}
