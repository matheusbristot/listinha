package com.bristot.listinha.di

import com.bristot.listinha.data.mapper.product.ProductMapper
import com.bristot.listinha.data.mapper.product.ProductMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object MapperModule {

    @Provides
    fun providesProductsMapper(): ProductMapper = ProductMapperImpl()
}
