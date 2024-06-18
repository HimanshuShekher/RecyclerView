package com.example.assignmentapplication.network


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://machintestapi.erpguru.in/"

    private val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
          //  .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: Network by lazy {
        instance.create(Network::class.java)
    }
}