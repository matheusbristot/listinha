package com.bristot.listinha.di

import com.bristot.listinha.data.builder.RetrofitBuilder
import com.bristot.listinha.data.service.ProductsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import retrofit2.Retrofit
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
internal object DataModule {

    @Singleton
    @Provides
    fun bindDataBuilder(builder: RetrofitBuilder): Retrofit {
        return builder.getClient()
    }

    @Provides
    fun provideProductsService(retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }
}
