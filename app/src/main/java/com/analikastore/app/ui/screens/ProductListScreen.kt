package com.analikastore.app.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.analikastore.app.data.MockRepository
import com.analikastore.app.data.Product
import kotlinx.coroutines.launch

@Composable
fun ProductListScreen(onProductClick: (Int) -> Unit, onBack: () -> Unit) {
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    LaunchedEffect(Unit) { products = MockRepository.fetchProducts() }

    LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        items(products) { product ->
            Card(modifier = Modifier.fillMaxWidth().padding(6.dp).clickable { onProductClick(product.id) }) {
                Row(modifier = Modifier.padding(12.dp)) {
                    AsyncImage(model = product.imageUrl, contentDescription = product.name, modifier = Modifier.size(80.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(text = product.name)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "₹${product.price}")
                    }
                }
            }
        }
    }
}
