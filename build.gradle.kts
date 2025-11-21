// root build.gradle.kts
plugins {
    // Provide AGP (apply false so modules apply it)
    id("com.android.application") version "8.2.0" apply false

    // Kotlin plugin (use version 2.1.0 to match the libraries in your logs)
    id("org.jetbrains.kotlin.android") version "2.1.0" apply false

    // Google services plugin for Firebase — version declared here
    id("com.google.gms.google-services") version "4.3.15" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
