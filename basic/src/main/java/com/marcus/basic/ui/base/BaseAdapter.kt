package com.marcus.basic.ui.base

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : Parcelable, V: ViewDataBinding> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    protected val data = arrayListOf<T>()

    lateinit var binding: V

    var onItemClickListener: OnItemClickListener<T>? = null

    interface OnItemClickListener<T : Parcelable> {
        fun onItemClick(pos: Int, data: T)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    abstract fun getLayoutId(viewType: Int): Int

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.onItemClickListener = onItemClickListener
        holder.onBind(position, data[position], holder.binding)
        holder.binding.executePendingBindings()
    }

    fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return DataBindingUtil.inflate(LayoutInflater.from(parent.context), getLayoutId(viewType), parent, false)
    }

    open fun setItems(list: List<T>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    open fun addItems(list: List<T>) {
        data.addAll(list!!)
        notifyItemRangeInserted(data.size , list.size)
    }

    val items: List<T>
        get() = data

    fun clearItems() {
        data.clear()
    }

    fun updateItem(pos: Int, value: T) {
        data[pos] = value
        notifyItemChanged(pos)
    }
}
