package com.marcus.cathay.ui.home

import androidx.databinding.ViewDataBinding
import com.marcus.basic.ui.base.BaseViewHolder
import com.marcus.cathay.data.response.PavilionDetail
import com.marcus.cathay.databinding.ItemHomeBinding

class HomeViewHolder(binding: ViewDataBinding) : BaseViewHolder<PavilionDetail>(binding) {

    override fun onBind(position: Int, data: PavilionDetail, binding: ViewDataBinding) {
        (binding as ItemHomeBinding).data = data
        binding.breakTime.isSelected = true

        binding.root.setOnClickListener {
            onItemClickListener?.onItemClick(position, data)
        }
    }
}