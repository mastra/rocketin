package com.molol.rocketin.data.api

import com.molol.rocketin.BuildConfig
import com.molol.rocketin.model.BarResult
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/maps/api/place/textsearch/json")
    suspend fun search(@Query("query") query:String, @Query("key") key:String = BuildConfig.MAPS_API_KEY, @Query("sensor") sensor: Boolean = false ) : Response<BarResult>

    companion object {

        private const val BASE_URL = "https://maps.googleapis.com/"

        fun getService() : ApiService {

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) )

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .build()
            return retrofit.create(ApiService::class.java)

        }
    }
}