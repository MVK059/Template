package com.mvk.base.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    lateinit var dataBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupDataBinding()
        setupView(savedInstanceState)
    }

    private fun setupDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, provideLayoutId())
//        dataBinding.setVariable(provideDataBindingVariable(), viewModel)
        dataBinding.executePendingBindings()
    }

    protected abstract fun provideDataBindingVariable(): Int

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun setupView(savedInstanceState: Bundle?)
}