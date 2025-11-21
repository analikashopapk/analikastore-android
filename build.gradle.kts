// build.gradle.kts (root)

plugins {
    // AGP (apply false — modules will apply it)
    id("com.android.application") version "8.2.0" apply false

    // Kotlin plugin — match libraries (logs showed Kotlin metadata 2.1.0)
    id("org.jetbrains.kotlin.android") version "2.1.0" apply false

    // Google services plugin for Firebase — declare version here (apply false)
    id("com.google.gms.google-services") version "4.3.15" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
