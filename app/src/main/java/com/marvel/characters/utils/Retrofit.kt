package com.marvel.characters.utils

import com.google.gson.GsonBuilder
import com.marvel.characters.service.BASE_URL
import okhttp3.OkHttpClient
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