package com.mvk.template

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.mvk.base.ui.BaseActivity
import com.mvk.network.NetworkService
import com.mvk.template.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var networkService: NetworkService

    private val mainViewModel: MainViewModel by viewModels {
        ViewModelProviderFactory(MainViewModel::class) { MainViewModel() }
    }


    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setupView(savedInstanceState: Bundle?) {
        Log.d("DaggerSample_Main", networkService.toString())
        Log.d("DaggerSample_Main", mainViewModel.toString())
    }

    override fun provideDataBindingVariable(): Int = BR.mainVM
}