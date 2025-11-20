plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.analikastore.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.analikastore.app"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
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
    // Firebase BOM — put this near the top of dependencies
    implementation(platform("com.google.firebase:firebase-bom:34.6.0"))

    // Firebase libraries (no explicit versions when using BoM)
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx") // optional if you use analytics

    // other dependencies (leave as they are) ...
}
