package com.mvk.base.di

import android.content.Context
import android.content.SharedPreferences
import com.mvk.base.utils.network.NetworkHelper
import com.mvk.network.BuildConfig
import com.mvk.network.NetworkService
import com.mvk.network.Networking
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class BaseModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("bootcamp-instagram-project-prefs", Context.MODE_PRIVATE)

//    @Provides
//    @Singleton
//    fun provideDatabaseService(@ApplicationContext context: Context): DatabaseService =
//        Room.databaseBuilder(
//            context, DatabaseService::class.java,
//            "bootcamp-instagram-project-db"
//        ).build()

    @Provides
    @Singleton
    fun provideNetworkService(@ApplicationContext context: Context): NetworkService =
        Networking.create(
            BuildConfig.API_KEY,
            BuildConfig.BASE_URL,
            context.cacheDir,
            10 * 1024 * 1024 // 10MB
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper =
        NetworkHelper(context)

}