package com.analikastore.app.ui.screens

import com.analikastore.app.firebase.FirebaseAuthWrapper

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.analikastore.app.data.MockRepository
import com.analikastore.app.data.NetworkModule
import com.analikastore.app.payment.RazorpayHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CheckoutScreen(onComplete: () -> Unit, onBack: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    val activity = androidx.compose.ui.platform.LocalContext.current as Activity

    if (FirebaseAuthWrapper.currentUser() == null) { androidx.compose.runtime.LaunchedEffect(Unit) { androidx.compose.ui.platform.LocalContext.current.let { (it as android.app.Activity).runOnUiThread { androidx.compose.ui.platform.LocalContext.current.applicationContext } } } androidx.compose.runtime.Composable {} } else { Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Checkout")
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = address, onValueChange = { address = it }, label = { Text("Address") })
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            // Create an order on backend for payment (recommended)
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    // Backend should return JSON: { "order_id": "...", "amount": 12345 } where amount is in paise
                    val orderResp = NetworkModule.apiService.placeOrder(mapOf("name" to name, "address" to address, "items" to MockRepository.getCartItems().map { mapOf("productId" to it.product.id, "quantity" to it.quantity) }))
                    if (orderResp.isSuccessful) {
                        val body = orderResp.body()
                        val orderId = body?.get("order_id")?.toString()
                        val amount = body?.get("amount")?.toString()?.toIntOrNull() ?: 0
                        // Start Razorpay checkout
                        RazorpayHelper.startPayment(activity, amount, orderId)
                        // Note: handle callbacks in Activity if you implement PaymentResultListener
                        // After payment success, your backend should confirm and finalize order; here we mock success
                        MockRepository.clearCart()
                        // Return to UI thread
                        kotlinx.coroutines.withContext(Dispatchers.Main) { onComplete() }
                        return@launch
                    }
                } catch (e: Exception) {
                    // fallback to mock place order if backend not available
                }
                val success = MockRepository.placeOrder(name, address)
                if (success) {
                    kotlinx.coroutines.withContext(Dispatchers.Main) { onComplete() }
                }
            }
        }) { Text("Pay & Place Order") }
    }
}
