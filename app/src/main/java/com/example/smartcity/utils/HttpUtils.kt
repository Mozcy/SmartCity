package com.example.smartcity.utils

import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

var baseURL = "http://192.168.8.110:10001"

var token = ""
val gson = Gson()
val client = OkHttpClient.Builder().build()

inline fun <reified T> get(url: String, crossinline ok: (T) -> Unit) {
    call(request("GET", url, null), ok)
}

inline fun <reified T> post(url: String, map: Map<*, *>, crossinline ok: (T) -> Unit) {
    val body = gson.toJson(map).toRequestBody("application/json".toMediaType())
    call(request("POST", url, body), ok)
}

inline fun <reified T> post(url: String, body: MultipartBody, crossinline ok: (T) -> Unit) {
    call(request("POST", url, body), ok)
}

inline fun <reified T> put(url: String, map: Map<*, *>, crossinline ok: (T) -> Unit) {
    val body = gson.toJson(map).toRequestBody("application/json".toMediaType())
    call(request("PUT", url, body), ok)
}

fun request(method: String, url: String, body: RequestBody? = null): Request {
    return Request.Builder().url("${baseURL}/prod-api" + url).method(method, body).also {
        if (token.isNotEmpty()) it.addHeader("Authorization", token)
    }.build()
}

inline fun <reified T> call(request: Request, crossinline ok: (T) -> Unit) {
    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {}

        override fun onResponse(call: Call, response: Response) {
            val data = response.body?.string()
            if (Looper.myLooper() == null) Looper.prepare()
            Handler(Looper.getMainLooper()).post {
                try {
                    ok(gson.fromJson(data, T::class.java))
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    })
}