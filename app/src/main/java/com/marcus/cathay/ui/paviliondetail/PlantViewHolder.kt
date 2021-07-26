package com.marcus.cathay.ui.paviliondetail

import androidx.databinding.ViewDataBinding
import com.marcus.basic.ui.base.BaseViewHolder
import com.marcus.cathay.data.response.PlantDetail
import com.marcus.cathay.databinding.ItemPlantBinding

class PlantViewHolder(binding: ViewDataBinding) : BaseViewHolder<PlantDetail>(binding) {

    override fun onBind(position: Int, data: PlantDetail, binding: ViewDataBinding) {
        (binding as ItemPlantBinding).data = data
        binding.root.setOnClickListener {
            onItemClickListener?.onItemClick(position, data)
        }
    }
}