package com.analikastore.app.ui.screens

import com.analikastore.app.firebase.FirebaseAuthWrapper

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.analikastore.app.data.MockRepository

@Composable
fun CartScreen(onCheckout: () -> Unit, onBack: () -> Unit) {
    val items = MockRepository.getCartItems()
    if (FirebaseAuthWrapper.currentUser() == null) { androidx.compose.runtime.LaunchedEffect(Unit) { androidx.compose.ui.platform.LocalContext.current.let { (it as android.app.Activity).runOnUiThread { androidx.compose.ui.platform.LocalContext.current.applicationContext } } } androidx.compose.runtime.Composable {} } else { Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (items.isEmpty()) Text("Cart is empty") else {
            LazyColumn { items(items) { ci -> Text("${ci.product.name} x ${ci.quantity} - ₹${ci.product.price * ci.quantity}") } }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = onCheckout) { Text("Proceed to Checkout") }
        }
    }
}
