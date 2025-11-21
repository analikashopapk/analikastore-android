// root build.gradle.kts
plugins {
    // AGP (modules apply it with `apply false`)
    id("com.android.application") version "8.2.0" apply false

    // Kotlin plugin (keep version consistent with libs)
    id("org.jetbrains.kotlin.android") version "2.1.0" apply false

    // Google services plugin for Firebase (declared here)
    id("com.google.gms.google-services") version "4.3.15" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
