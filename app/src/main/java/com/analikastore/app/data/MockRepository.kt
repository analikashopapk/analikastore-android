package com.analikastore.app.data

import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException

object MockRepository {
    private val products = listOf(
        Product(1, "Smartphone X", "A fast smartphone", 299.99, "https://via.placeholder.com/200", 10),
        Product(2, "Laptop Pro", "Lightweight laptop", 899.99, "https://via.placeholder.com/200", 5),
        Product(3, "Wireless Headphones", "Noise-cancelling", 149.99, "https://via.placeholder.com/200", 20),
        Product(4, "Smart TV 55\"", "4K Smart TV", 599.99, "https://via.placeholder.com/200", 3)
    )

    private val cart = mutableListOf<CartItem>()

    /**
     * Fetch products: first try network via NetworkModule.apiService,
     * if that fails (no network / endpoint missing) fall back to local list.
     */
    suspend fun fetchProducts(): List<Product> {
        try {
            val resp = NetworkModule.apiService.getProducts()
            if (resp.isSuccessful) {
                val body = resp.body()
                if (body != null && body.isNotEmpty()) return body
            }
        } catch (e: IOException) {
            // network issue - fallthrough to local data
        } catch (e: HttpException) {
            // server returned error - fallthrough to local data
        } catch (t: Throwable) {
            // unexpected - fallthrough
        }
        delay(200)
        return products
    }

    suspend fun getProductById(id: Int): Product? {
        try {
            val resp = NetworkModule.apiService.getProduct(id)
            if (resp.isSuccessful) {
                resp.body()?.let { return it }
            }
        } catch (e: Exception) {
            // ignore and fallback
        }
        delay(150)
        return products.find { it.id == id }
    }

    fun getCartItems(): List<CartItem> = cart

    fun addToCart(product: Product, qty: Int = 1) {
        val existing = cart.find { it.product.id == product.id }
        if (existing != null) existing.quantity += qty else cart.add(CartItem(product, qty))
    }

    fun updateQuantity(productId: Int, qty: Int) {
        val item = cart.find { it.product.id == productId } ?: return
        if (qty <= 0) cart.remove(item) else item.quantity = qty
    }

    fun clearCart() { cart.clear() }

    /**
     * Place order: attempts to call backend /api/orders with name/address and cart items.
     * If backend call succeeds and returns success, clear cart and return true.
     * Otherwise fallback to mocked success for development.
     */
    suspend fun placeOrder(name: String, address: String): Boolean {
        try {
            val orderBody = mapOf(
                "name" to name,
                "address" to address,
                "items" to cart.map { mapOf("productId" to it.product.id, "quantity" to it.quantity) }
            )
            val resp = NetworkModule.apiService.placeOrder(orderBody)
            if (resp.isSuccessful) {
                clearCart()
                return true
            }
        } catch (e: Exception) {
            // fallback
        }
        delay(400)
        clearCart()
        return true
    }

    suspend fun bookService(booking: ServiceBooking): Boolean {
        try {
            val resp = NetworkModule.apiService.createBooking(booking)
            if (resp.isSuccessful) return true
        } catch (e: Exception) {
            // fallback to mock
        }
        delay(300)
        return true
    }
}
