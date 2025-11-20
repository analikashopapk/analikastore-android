// Top-level build.gradle.kts — minimal safe version.
// Repositories are configured in settings.gradle.kts (dependencyResolutionManagement).

// You can add common pluginManagement or buildscript settings here if needed.
buildscript {
    // intentionally empty: repositories are provided in settings.gradle.kts
    dependencies {
        // add buildscript classpath entries here only if absolutely necessary
    }
}

// Keep this file minimal; avoid calling `repositories { ... }` here
// as settings.gradle.kts configures repositories centrally.
