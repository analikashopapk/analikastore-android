package com.analikastore.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.analikastore.app.ui.EcommerceApp
// Firebase imports will be active once you add Firebase dependencies and google-services.json
// import com.google.firebase.ktx.Firebase
// import com.google.firebase.ktx.initialize

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Firebase initialization note:
        // If you add google-services.json and Firebase dependencies, FirebaseApp.initializeApp(this) will be called automatically
        // via the google services plugin. Add initialization here if you need to perform custom setup.
        setContent {
            EcommerceApp()
        }
    }
}
