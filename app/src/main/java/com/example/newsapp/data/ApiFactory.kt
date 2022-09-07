package com.example.newsapp.data

import com.example.newsapp.data.QueryConstants.API_KEY
import com.example.newsapp.data.QueryConstants.API_KEY_STR
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://newsapi.org/v2/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(getClient())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)

    private fun getClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain -> return@addInterceptor addApiKeyToRequests(chain) }
        .build()

    private fun addApiKeyToRequests(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url
        val newUrl = originalHttpUrl.newBuilder()
            .addQueryParameter(API_KEY, API_KEY_STR).build()
        request.url(newUrl)
        return chain.proceed(request.build())
    }
}