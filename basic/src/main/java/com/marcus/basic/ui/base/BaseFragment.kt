package com.marcus.basic.ui.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.marcus.basic.manager.LoadingDialogManager

abstract class BaseFragment<V: ViewDataBinding> : Fragment(), IBaseView {

    protected lateinit var binding: V

    protected var isCreate = false

    protected lateinit var attachContext: Context

    @Override
    override fun onAttach(context: Context) {
        super.onAttach(context)
        attachContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCreate = true
    }

    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = this
        initialUi()

        if(isCreate){
            loadData()
        }
        return binding.root
    }

    override fun showLoading() {
        if(attachContext is Activity)
            LoadingDialogManager.getInstance().showLoading(attachContext as Activity)
    }

    override fun closeLoading() {
        LoadingDialogManager.getInstance().closeLoading()
    }

    override fun showMessage(msg: String?) {
        Toast.makeText(attachContext as Activity, msg, Toast.LENGTH_LONG).show()
    }

    @Override
    abstract fun loadData()

    @Override
    abstract fun initialUi()

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onDestroyView() {
        super.onDestroyView()
        isCreate = false
    }

    @Override
    override fun onDestroy() {
        LoadingDialogManager.getInstance().closeLoading()
        super.onDestroy()
    }

}