package com.bristot.listinha.data.builder

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import javax.inject.Inject

private const val BASE_URL = "http://627c20e3e5ac2c452aec4790.mockapi.io/api/v1/"
private const val CONTENT_TYPE = "application/json"

@ExperimentalSerializationApi
internal class RetrofitBuilder @Inject constructor(): DataBuilder {

    private val type: MediaType = MediaType.get(CONTENT_TYPE)

    override fun getClient(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory(type))
        .build()
}
