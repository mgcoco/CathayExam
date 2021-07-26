package com.marcus.cathay.ui.home

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.marcus.basic.ui.base.BaseAdapter
import com.marcus.cathay.R
import com.marcus.cathay.data.response.PavilionDetail
import javax.inject.Inject

class HomeAdapter @Inject constructor(): BaseAdapter<PavilionDetail, ViewDataBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return  HomeViewHolder(
            super.createBinding(parent, viewType)
        )
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_home
    }

}