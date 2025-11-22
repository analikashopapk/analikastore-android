package com.analikastore.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

@Composable
fun HomeScreen(onOpenCategory: () -> Unit, onOpenBooking: () -> Unit, onOpenCart: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "Welcome to Analika Store")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onOpenCategory) { Text("Shop Electronics") }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onOpenBooking) { Text("Service Booking") }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onOpenCart) { Text("View Cart") }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { // Test Crash (Crashlytics)
            Firebase.crashlytics.log("Test crash pressed")
            // Uncomment below line to force a crash during testing
            // throw RuntimeException("Test Crash from AnalikaStore App")
        }) { Text("Test Crash (dev)") }
    }
}
