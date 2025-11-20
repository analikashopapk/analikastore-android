plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services") apply false
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.analikastore.app"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            // proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    // Firebase BOM (manage firebase versions centrally)
    implementation(platform("com.google.firebase:firebase-bom:34.6.0"))

    // Firebase libraries (no explicit versions when using BOM)
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")

    // Common Android libraries — keep these or update to match your project
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.recyclerview:recyclerview:1.3.0")

    // Networking & image loading placeholders (adjust if your project differs)
    implementation("io.coil-kt:coil:2.4.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Optional: logging, lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
}
