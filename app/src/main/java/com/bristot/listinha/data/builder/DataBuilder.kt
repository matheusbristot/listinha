package com.bristot.listinha.data.builder

import retrofit2.Retrofit

interface DataBuilder {

    fun getClient() : Retrofit
}