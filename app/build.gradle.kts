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
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.21") // pick matching Kotlin version your project uses

    // --- Firebase BOM (declare once, before KTX libs) ---
    implementation(platform("com.google.firebase:firebase-bom:34.6.0"))

    // Firebase KTX libraries (no explicit versions when using BOM)
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")

    // If you need non-KTX core libs (not necessary with KTX)
    // implementation("com.google.firebase:firebase-messaging")
    // implementation("com.google.firebase:firebase-analytics")

    // Lottie (if used)
    implementation("com.airbnb.android:lottie:6.1.0")

    // AndroidX / common libs
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
