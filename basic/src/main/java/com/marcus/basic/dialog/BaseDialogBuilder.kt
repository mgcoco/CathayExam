package com.marcus.basic.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseDialogBuilder(var context: Context) {

    var isCancelable = true

    var isCancelOutside = false

    var onDismissListener: DialogInterface.OnDismissListener? = null

    protected lateinit var dialog: Dialog

    protected var view: View? = null

    protected var binding: ViewDataBinding? = null


    fun create(layout: Int, style: Int) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), layout, null, false)
        view = binding?.root

        dialog = Dialog(context, style)
        dialog.setContentView(view!!)
        dialog.setCancelable(isCancelable)
        dialog.setCanceledOnTouchOutside(isCancelOutside)
    }
}