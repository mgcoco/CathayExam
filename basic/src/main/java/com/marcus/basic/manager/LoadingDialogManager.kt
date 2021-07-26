package com.marcus.basic.manager

import android.app.Activity
import android.app.Dialog
import com.marcus.basic.dialog.LoadingDialog

class LoadingDialogManager{

    companion object {
        @Volatile private var instance: LoadingDialogManager? = null

        fun getInstance(): LoadingDialogManager =
            instance ?: synchronized(this) {
                instance ?: LoadingDialogManager().also { instance = it }
            }
    }

    private var dialog: Dialog? = null

    fun showLoading(activity: Activity){
        if(dialog == null) {
            dialog = LoadingDialog.Builder(activity).also {
                it.isCancelOutside = false
                it.isCancelable = false
            }.create()
        }
        if(!activity.isFinishing && !dialog!!.isShowing) {
            dialog!!.show()
        }
    }

    fun closeLoading() {
        dialog?.dismiss()
        dialog = null
    }
}