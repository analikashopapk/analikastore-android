import org.gradle.kotlin.dsl.version

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") // Make sure Kotlin plugin applied once
}

android {
    namespace = "com.analikastore.app"           // required for AGP 7.0+
    compileSdk = 34

    defaultConfig {
        applicationId = "com.analikastore.app"
        minSdk = 23               // library firebase-messaging requires min 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

// inside app/build.gradle.kts — replace the entire dependencies { ... } block with this
dependencies {
    // Firebase BOM (put this first — it supplies versions for KTX/artifact coordinates without explicit versions)
    implementation(platform("com.google.firebase:firebase-bom:34.6.0"))

    // Firebase libraries (no versions needed because BOM provides them)
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")

    // Optional: if you need non-ktx artifacts explicitly (usually not needed when using BOM)
    // implementation("com.google.firebase:firebase-messaging")
    // implementation("com.google.firebase:firebase-analytics")

    // Common Android libraries
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.3.0")

    // other dependencies...
}
