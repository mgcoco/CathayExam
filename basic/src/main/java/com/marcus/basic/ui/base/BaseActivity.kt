package com.marcus.basic.ui.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.multidex.MultiDex
import com.marcus.basic.manager.LoadingDialogManager

open abstract class BaseActivity<V : ViewDataBinding> : AppCompatActivity(), IBaseView {

    protected lateinit var binding: V

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        MultiDex.install(newBase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.lifecycleOwner = this
        initialUi()
        loadData()
    }

    @Override
    abstract fun initialUi()

    @Override
    abstract fun loadData()

    @LayoutRes
    abstract fun getLayoutId(): Int

    @Override
    override fun onDestroy() {
        closeLoading()
        super.onDestroy()
    }

    override fun showLoading() {
        LoadingDialogManager.getInstance().showLoading(this)
    }

    override fun closeLoading() {
        LoadingDialogManager.getInstance().closeLoading()
    }

    override fun showMessage(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

}