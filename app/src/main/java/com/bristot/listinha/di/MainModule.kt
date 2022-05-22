package com.bristot.listinha.di

import com.bristot.listinha.domain.random.RandomUseCase
import com.bristot.listinha.domain.random.RandomUseCaseImpl
import com.bristot.listinha.domain.products.GetProductsUseCaseImpl
import com.bristot.listinha.domain.products.GetProductsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class MainModule {

    @Binds
    abstract fun bindRandomUseCase(useCaseImpl: RandomUseCaseImpl): RandomUseCase

    @Binds
    abstract fun bindGetProductUseCase(useCase: GetProductsUseCaseImpl): GetProductsUseCase
}
