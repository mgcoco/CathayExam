package com.marcus.basic.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import com.jcodecraeer.xrecyclerview.ProgressStyle
import com.marcus.basic.R
import com.marcus.basic.databinding.DialogLoadingBinding

class LoadingDialog constructor(
    context: Context,
    cancelable: Boolean,
    cancelListener: DialogInterface.OnCancelListener?
) : Dialog(context, cancelable, cancelListener) {

    class Builder(context: Context) : BaseDialogBuilder(context) {

        private var message: String? = null

        private var isShowMessage = true

        fun create(): Dialog {
            super.create(R.layout.dialog_loading, R.style.CustomAlertDialog)

            if (isShowMessage) {
                if(message != null) {
                    (binding as DialogLoadingBinding).loadingMessage.text = message
                }
            }
            else {
                (binding as DialogLoadingBinding).loadingMessage.visibility = View.GONE
            }
            (binding as DialogLoadingBinding).progress.setIndicatorColor(Color.WHITE)
            (binding as DialogLoadingBinding).progress.setIndicatorId(ProgressStyle.LineScaleParty)
            val window = dialog.window
            window!!.setLayout(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            window.setGravity(Gravity.CENTER)
            return dialog
        }
    }
}