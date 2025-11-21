import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") // keep only one kotlin plugin
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
    // If you prefer android.kotlinOptions (works with Kotlin Android plugin), you can keep:
    // kotlinOptions {
    //     jvmTarget = "17"
    // }
}

// Ensure kotlin jvm target consistently:
tasks.withType(KotlinCompile::class.java).configureEach {
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

    // (OPTIONAL) You usually don't need to add stdlib explicitly. If you do, ensure it matches the Kotlin plugin version.
    // implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.0")

    // Lottie for splash animation
    implementation("com.airbnb.android:lottie:6.1.0")

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
