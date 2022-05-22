package com.bristot.listinha.di

import com.bristot.listinha.data.repository.product.ProductRepositoryImpl
import com.bristot.listinha.domain.products.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DomainModule {

    @Binds
    abstract fun bindProductRepository(repository: ProductRepositoryImpl): ProductRepository
}