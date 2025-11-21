plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.analikastore.app"

    compileSdk = 34

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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    // Firebase BOM – controls all Firebase versions
    implementation(platform("com.google.firebase:firebase-bom:34.6.0"))

    // Firebase (no explicit versions when using BOM)
    implementation("com.google.firebase:firebase-messaging")
    implementation("com.google.firebase:firebase-analytics")

    // Kotlin stdlib (matches plugin)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.0")

    // Lottie for splash animation
    implementation("com.airbnb.android:lottie:6.1.0")

xmlns:app="http://schemas.android.com/apk/res-auto"
...
<com.airbnb.lottie.LottieAnimationView
    app:lottie_rawRes="@raw/your_animation"
    app:lottie_autoPlay="true"
    app:lottie_loop="true" />


    // AndroidX / UI
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.recyclerview:recyclerview:1.3.0")

    // Networking & images
    implementation("io.coil-kt:coil:2.4.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
}
