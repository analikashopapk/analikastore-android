// Root build.gradle.kts
plugins {
    id("com.android.application") version "8.1.0" apply false       // <- replace with your AGP version
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false // <- replace with your Kotlin version
    id("com.google.gms.google-services") version "4.4.0" apply false // <- replace with your Google services version
}

// Provide repositories so plugin resolution and subprojects can resolve dependencies
buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
