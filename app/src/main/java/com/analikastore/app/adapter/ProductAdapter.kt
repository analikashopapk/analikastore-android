package com.analikastore.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.analikastore.app.R
import com.analikastore.app.model.Product

class ProductAdapter(private val data: List<Product>) : RecyclerView.Adapter<ProductAdapter.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgProduct)
        val title: TextView = view.findViewById(R.id.tvTitle)
        val price: TextView = view.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return Holder(v)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val p = data[position]
        holder.title.text = p.title
        holder.price.text = p.price
        if (p.imageUrl.isNotBlank()) {
            holder.img.load(p.imageUrl) {
                placeholder(R.mipmap.ic_launcher)
                error(R.mipmap.ic_launcher)
            }
        } else {
            holder.img.setImageResource(R.mipmap.ic_launcher)
        }
    }

    override fun getItemCount(): Int = data.size
}
