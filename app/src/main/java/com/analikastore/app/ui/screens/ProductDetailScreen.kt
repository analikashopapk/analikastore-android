package com.analikastore.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.analikastore.app.data.MockRepository

@Composable
fun ProductDetailScreen(productId: Int, onAddToCart: (Int) -> Unit, onBack: () -> Unit) {
    var product by remember { mutableStateOf<com.analikastore.app.data.Product?>(null) }
    LaunchedEffect(productId) { product = MockRepository.getProductById(productId) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        product?.let { p ->
            AsyncImage(model = p.imageUrl, contentDescription = p.name, modifier = Modifier.fillMaxWidth().height(200.dp))
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = p.name)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = p.description)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Price: ₹${p.price}")
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { MockRepository.addToCart(p, 1) }) { Text("Add to cart") }
        } ?: Text("Loading...")
    }
}
