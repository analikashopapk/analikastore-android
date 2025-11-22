package com.analikastore.app.payment

import android.app.Activity
import android.util.Log
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

/**
 * Usage:
 * 1) Obtain orderId and amount from your server (recommended)
 * 2) Call RazorpayHelper.startPayment(activity, amountInPaise, orderId, callback)
 */
object RazorpayHelper {
    fun startPayment(activity: Activity, amountPaise: Int, orderId: String?) {
        val co = Checkout()
        // Set your Razorpay key here or in manifest meta-data
        co.setKeyID("YOUR_RAZORPAY_KEY_ID")
        try {
            val options = JSONObject()
            options.put("name", "Analika Store")
            options.put("description", "Order #$orderId")
            // You can pass order_id from backend for authenticated payments
            if (orderId != null) options.put("order_id", orderId)
            options.put("currency", "INR")
            options.put("amount", amountPaise) // amount in paise

            val prefill = JSONObject()
            prefill.put("email", "")
            prefill.put("contact", "")
            options.put("prefill", prefill)

            co.open(activity, options)
        } catch (e: Exception) {
            Log.e("Razorpay", "Error in starting Razorpay Checkout", e)
        }
    }
}
