package com.analikastore.app.ui.screens

import com.analikastore.app.firebase.FirebaseAuthWrapper

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.analikastore.app.data.ServiceBooking
import com.analikastore.app.data.MockRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ServiceBookingScreen(onBooked: () -> Unit, onBack: () -> Unit) {
    var productIdText by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var schedule by remember { mutableStateOf("") }

    if (FirebaseAuthWrapper.currentUser() == null) { androidx.compose.runtime.LaunchedEffect(Unit) { androidx.compose.ui.platform.LocalContext.current.let { (it as android.app.Activity).runOnUiThread { androidx.compose.ui.platform.LocalContext.current.applicationContext } } } androidx.compose.runtime.Composable {} } else { Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Service Booking (Electronics)")
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = productIdText, onValueChange = { productIdText = it }, label = { Text("Product ID (e.g. 1)") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Your name") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = address, onValueChange = { address = it }, label = { Text("Address") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = schedule, onValueChange = { schedule = it }, label = { Text("Preferred date/time") })
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            val pid = productIdText.toIntOrNull() ?: 0
            val booking = ServiceBooking(id = (0..100000).random(), productId = pid, customerName = name, address = address, scheduledAt = schedule)
            CoroutineScope(Dispatchers.IO).launch {
                val r = MockRepository.bookService(booking)
                if (r) onBooked()
            }
        }) { Text("Book Service (Mock)") }
    }
}
