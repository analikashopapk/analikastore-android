// Only one plugins block here — we *do not* specify versions here because settings.gradle.kts manages them.
plugins {
    // declare plugin coordinates for use by subprojects, but don't apply them in root
    id("com.android.application") apply false
    id("org.jetbrains.kotlin.android") apply false
    id("com.google.gms.google-services") apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

// Put other root-level configuration here if needed (e.g., versions, common repositories)
