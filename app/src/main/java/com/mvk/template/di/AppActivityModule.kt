package com.mvk.template.di

import android.app.Activity
import androidx.lifecycle.ViewModelProvider
import com.mvk.base.ui.BaseActivity
import com.mvk.template.MainViewModel
import com.mvk.template.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
object AppActivityModule {

}