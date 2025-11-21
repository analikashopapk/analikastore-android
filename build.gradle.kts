// root build.gradle.kts

plugins {
    // Android Gradle Plugin (apply false so modules apply it)
    id("com.android.application") version "8.2.0" apply false

    // Kotlin plugin - keep version consistent with Kotlin runtime you want to use
    id("org.jetbrains.kotlin.android") version "2.1.0" apply false

    // Google Services plugin
    id("com.google.gms.google-services") version "4.3.15" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
