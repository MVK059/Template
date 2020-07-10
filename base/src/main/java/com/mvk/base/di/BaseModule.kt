package com.mvk.base.di

import com.mvk.network.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class BaseModule {

    @Provides
    @Singleton
    fun provideNetworkService() = NetworkService()
}