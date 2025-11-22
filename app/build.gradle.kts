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

dependencies {
    // Use Firebase BOM to manage Firebase libs versions centrally.
    // Put this BEFORE any firebase implementation(...) lines.
    implementation(platform("com.google.firebase:firebase-bom:34.6.0"))

    // Firebase libs (no explicit versions needed when BOM is used)
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")

    // If you additionally need non-KTX artifacts (rare with BOM), list them AFTER the BOM:
    // implementation("com.google.firebase:firebase-messaging")
    // implementation("com.google.firebase:firebase-analytics")

    // Common Android libraries — keep or adjust versions as needed
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.3.0")
    // ... other dependencies ...
}
