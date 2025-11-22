package com.analikastore.app.data

import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("/api/products")
    suspend fun getProducts(): Response<List<Product>>

    @GET("/api/products/{id}")
    suspend fun getProduct(@Path("id") id: Int): Response<Product>

    @GET("/api/cart")
    suspend fun getCart(): Response<List<CartItem>>

    @POST("/api/cart")
    suspend fun updateCart(@Body items: List<CartItem>): Response<Unit>

    @POST("/api/orders")
    suspend fun placeOrder(@Body order: Map<String, Any>): Response<Map<String, Any>>

    @POST("/api/bookings")
    suspend fun createBooking(@Body booking: ServiceBooking): Response<Map<String, Any>>
}
