package com.subeenie.yes24_android.application

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.subeenie.yes24_android.application.Constant.YES24_BASE_URL
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import timber.log.Timber
import java.io.IOException

object ApiFactory {

    private fun provideOkHttpClient(interceptor: AppInterceptor): OkHttpClient =
        OkHttpClient.Builder().run {
            addInterceptor(interceptor)
            build()
        }

    private val yes24Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(YES24_BASE_URL)
            .client(provideOkHttpClient(AppInterceptor()))
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    val yes24Service:Yes24Service by lazy {
        yes24Retrofit.create(Yes24Service::class.java)
    }

    class AppInterceptor : Interceptor { // Logcat으로 서버통신 확인하라고 Interceptor 남겨둡니다!
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
            val request = request()
            val response = proceed(request)
            Timber.d(request.toString())
            if(response.code in 200..299)
                Timber.d(response.toString())
            else if(response.code in 400..599)
                Timber.e(response.toString())

            return response
        }
    }
}