package com.marcus.basic.ui.base

import android.content.Context
import android.os.Parcelable
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T: Parcelable> :
    RecyclerView.ViewHolder {

    protected var context: Context

    var binding: ViewDataBinding

    var onItemClickListener: BaseAdapter.OnItemClickListener<T>? = null

    constructor(binding: ViewDataBinding) : super(binding.root) {
        this.binding = binding
        this.context = binding.root.context
    }

    abstract fun onBind(position: Int, data: T, binding: ViewDataBinding)
}
