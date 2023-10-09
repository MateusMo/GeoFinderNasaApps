package com.example.geofinder.data
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import com.google.gson.Gson

class LocationRepository {
    suspend fun sendLocationData(locationData: LocationData): Response {
        val gson = Gson()
        val json = gson.toJson(locationData)
        val mediaType = "application/json; charset=utf-8".toMediaType()

        val requestBody = json.toRequestBody(mediaType)

        val request = Request.Builder()
            .url("https://localhost:7146/v1/PostMap") // Substitua pela URL real do seu endpoint
            .post(requestBody)
            .build()

        val client = OkHttpClient()
        return client.newCall(request).execute()
    }
}