plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services") apply false
}

android {
    compileSdk = 34
    namespace = "com.analikastore.app"

    defaultConfig {
        applicationId = "com.analikastore.app"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Firebase BOM
    implementation(platform("com.google.firebase:firebase-bom:34.6.0"))

    // Firebase artifacts
    implementation("com.google.firebase:firebase-messaging")
    implementation("com.google.firebase:firebase-analytics")

    // Kotlin stdlib matching plugin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")

    // Lottie
    implementation("com.airbnb.android:lottie:5.2.0")

    // Core libraries
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.recyclerview:recyclerview:1.3.0")

    // Networking / image
    implementation("io.coil-kt:coil:2.4.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
}
