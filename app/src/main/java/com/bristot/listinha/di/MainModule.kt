package com.bristot.listinha.di

import com.bristot.listinha.domain.RandomUseCase
import com.bristot.listinha.domain.RandomUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MainModule {

    @Binds
    abstract fun bindRandomUseCase(useCaseImpl: RandomUseCaseImpl): RandomUseCase
}
