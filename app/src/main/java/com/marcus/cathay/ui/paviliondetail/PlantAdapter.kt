package com.marcus.cathay.ui.paviliondetail

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.marcus.basic.ui.base.BaseAdapter
import com.marcus.cathay.R
import com.marcus.cathay.data.response.PlantDetail
import javax.inject.Inject

class PlantAdapter @Inject constructor(): BaseAdapter<PlantDetail, ViewDataBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        return  PlantViewHolder(
            super.createBinding(parent, viewType)
        )
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_plant
    }
}