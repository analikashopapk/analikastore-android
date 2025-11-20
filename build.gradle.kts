// Top-level build.gradle.kts (minimal, ensures repositories available)
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        // optional: you can add classpath plugins here if required
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
