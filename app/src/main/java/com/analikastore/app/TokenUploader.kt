package com.analikastore.app

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException

object TokenUploader {
    private val client = OkHttpClient()

    private const val UPLOAD_URL = "https://www.analikastore.com/api/register_fcm"

    fun uploadToken(token: String): Boolean {
        val json = "{ \"token\": \"$token\" }"
        val body = RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), json)
        val req = Request.Builder()
            .url(UPLOAD_URL)
            .post(body)
            .build()
        return try {
            client.newCall(req).execute().use { resp ->
                resp.isSuccessful
            }
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }
}
