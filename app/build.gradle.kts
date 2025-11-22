plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.analikastore.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.analikastore.app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            // add signingConfigs when you have keys
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.6.0"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.material:material:1.5.0")
    implementation("androidx.navigation:navigation-compose:2.7.0")
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    // Razorpay SDK (sample) - add to project-level repo if needed
    implementation("com.razorpay:checkout:1.6.21")
    // Firebase dependencies will be added after google-services.json is placed
}

plugins { id("com.google.gms.google-services") }


repositories {
    google()
    mavenCentral()
}

dependencies {
    // Firebase BOM - manage versions
    implementation(platform("com.google.firebase:firebase-bom:32.2.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
}


/* Firebase modules added by assistant:
   - Authentication
   - Cloud Messaging
   - Crashlytics
   Make sure to update the BOM version if needed.
*/
plugins {
    // apply the Crashlytics Gradle plugin if you enable Crashlytics:
    // id("com.google.firebase.crashlytics")
}

dependencies {
    // Firebase BOM
    implementation(platform("com.google.firebase:firebase-bom:32.2.0"))
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")
}

// Note: Add the google services plugin at the top-level (already added).
