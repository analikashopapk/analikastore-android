package com.analikastore.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.analikastore.app.adapter.ProductAdapter
import com.analikastore.app.model.Product

class ProductsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val rv = findViewById<RecyclerView>(R.id.rvProducts)
        rv.layoutManager = LinearLayoutManager(this)
        val sample = listOf(
            Product("1", "Handmade Scarf", "₹799", ""),
            Product("2", "Cotton Kurta", "₹1299", ""),
            Product("3", "Brass Earrings", "₹499", "")
        )
        rv.adapter = ProductAdapter(sample)
    }
}
