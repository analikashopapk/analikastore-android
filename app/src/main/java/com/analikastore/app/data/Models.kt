package com.analikastore.app.data

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String,
    val stock: Int
)

data class CartItem(
    val product: Product,
    var quantity: Int
)

data class ServiceBooking(
    val id: Int,
    val productId: Int,
    val customerName: String,
    val address: String,
    val scheduledAt: String
)
