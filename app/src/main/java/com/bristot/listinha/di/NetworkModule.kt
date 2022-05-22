package com.bristot.listinha.di

import android.content.Context
import com.bristot.listinha.data.network.NetworkService
import com.bristot.listinha.data.network.NetworkServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    fun providesNetworkService(@ApplicationContext appContext: Context): NetworkService {
        return NetworkServiceImpl(appContext)
    }
}