plugins {
    id("com.android.application") version "8.1.0" apply false
    kotlin("android") version "1.9.10" apply false
    id("com.google.gms.google-services") version "4.3.15" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.google.gms:google-services:4.3.15")
    }
}

// Keep other existing settings below (if you already have other content, keep it).
// This file mainly provides plugin versions to the plugin portal and Google repo.
