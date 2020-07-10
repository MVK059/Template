package com.mvk.template.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.mvk.base.ui.BaseActivity
import com.mvk.base.ui.BaseViewModel
import com.mvk.base.utils.network.NetworkHelper
import com.mvk.instagram.utils.ViewModelProviderFactory
import com.mvk.template.BR
import com.mvk.template.ui.MainViewModel
import com.mvk.template.R
import com.mvk.template.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var networkHelper: NetworkHelper

    private val mainViewModel: MainViewModel by viewModels {
        ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(
                networkHelper
            )
        }
    }

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setupView(savedInstanceState: Bundle?) {
        Log.d("DaggerSample_Main", networkHelper.toString())
        Log.d("DaggerSample_Main", mainViewModel.toString())
    }

    override fun provideDataBindingVariable(): Int = BR.mainVM

    override fun provideViewModel(): BaseViewModel = mainViewModel
}