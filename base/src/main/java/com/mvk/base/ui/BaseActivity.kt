package com.mvk.base.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.mvk.base.utils.display.Toaster
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    lateinit var viewModel: BaseViewModel

    lateinit var dataBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        viewModel = provideViewModel()
        viewModel.onCreate()
        setupDataBinding()
        setupObservers()
        setupView(savedInstanceState)
    }

    open fun goBack() = onBackPressed()

    /**
     * TODO Check documentation for updated version
     */
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStackImmediate()
        else super.onBackPressed()
    }

    private fun setupDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, provideLayoutId())
        dataBinding.setVariable(provideDataBindingVariable(), viewModel)
        dataBinding.executePendingBindings()
    }

    private fun showMessage(message: String) = Toaster.show(applicationContext, message)

    private fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }

    protected abstract fun provideDataBindingVariable(): Int

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun setupView(savedInstanceState: Bundle?)

    protected abstract fun provideViewModel(): BaseViewModel
}