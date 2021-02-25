package com.marvel.characters.utils

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.gson.GsonBuilder
import com.marvel.characters.BuildConfig
import com.marvel.characters.network.BASE_URL
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val DEFAULT_TIMEOUT = 20000L

val defaultOkHttpClient: OkHttpClient
    get() {
        val builder = OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(loggingInterceptor)
        return builder
            .build()
    }

val defaultRetrofit: Retrofit
    get() {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(defaultOkHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().serializeNulls().create()
                )
            )
            .build()
    }

val loggingInterceptor: HttpLoggingInterceptor
    get() {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.BASIC
            }
        }
    }

/**
 * Supply every request with api key query parameters
 */
private val apiKeyInterceptor = object : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        val publicKey = Firebase.remoteConfig.getString("public_key")
        val now = System.currentTimeMillis()
        val hash = now.generateHash()
        val url: HttpUrl = request.url.newBuilder()
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash",hash)
            .addQueryParameter("ts",now.toString()).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}