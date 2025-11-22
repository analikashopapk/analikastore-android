plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.analikastore.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.analikastore.app"
        minSdk = 23              // updated for Firebase messaging compatibility
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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

    // If your project used viewBinding or dataBinding, enable here:
    // buildFeatures { viewBinding = true }
}

dependencies {
    // Firebase BOM manages versions
    implementation(platform("com.google.firebase:firebase-bom:34.6.0"))

    // Firebase libs (no version numbers when using BOM)
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")

    // AndroidX / material
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    
    // Lottie (if you use it)
    implementation("com.airbnb.android:lottie:6.1.0")

    // Add other dependencies your app needs here...
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
