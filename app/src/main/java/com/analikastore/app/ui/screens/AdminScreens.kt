package com.analikastore.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AdminProductsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Admin - Products (stub)")
        Text("Use your admin APIs to list/create/update products here.")
    }
}

@Composable
fun AdminOrdersScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Admin - Orders (stub)")
        Text("List orders via admin APIs.")
    }
}

@Composable
fun AdminBookingsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Admin - Bookings (stub)")
        Text("List service bookings via admin APIs.")
    }
}
