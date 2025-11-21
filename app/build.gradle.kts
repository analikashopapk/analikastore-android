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
    // Firebase BOM — single source of truth for firebase versions
    implementation(platform("com.google.firebase:firebase-bom:34.6.0"))

    // Firebase libraries (use main artifacts; Kotlin extensions are included)
    implementation("com.google.firebase:firebase-messaging")
    implementation("com.google.firebase:firebase-analytics")

    // Common Android libraries — keep/update as needed
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.recyclerview:recyclerview:1.3.0")

    // Networking & image loading placeholders (adjust if your project differs)
    implementation("io.coil-kt:coil:2.4.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // add Lottie animation library
    implementation("com.airbnb.android:lottie:5.2.0")

    // Optional: lifecycle/runtime
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

   // explicit Kotlin stdlib to ensure compatible kotlin runtime is on classpath
   implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")

}
