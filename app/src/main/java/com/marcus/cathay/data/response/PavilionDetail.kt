package com.marcus.cathay.data.response

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.marcus.cathay.R
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class PavilionDetail(
    //"E_Pic_URL":"http:\/\/www.zoo.gov.tw\/iTAP\/05_Exhibit\/01_FormosanAnimal.jpg",
    //"E_Geo":"MULTIPOINT ((121.5805931 24.9985962))",
    //"E_Info":"臺灣動物區以臺灣原生動物與棲息環境為展示重點，佈置模擬動物原生棲地之生態環境，讓動物表現如野外般自然的生活習性，引導觀賞者更正確地認識本土野生動物。臺灣位處於亞熱帶，雨量充沛、氣候溫暖，擁有各種地形景觀，因而孕育了豐富龐雜的生物資源。",
    //"E_no":"1",
    //"E_Category":"戶外區",
    //"E_Name":"臺灣動物區",
    //"E_Memo":"",
    //"_id":1,
    //"E_URL":"http:\/\/www.zoo.gov.tw\/introduce\/gq.aspx?tid=12"
    @SerializedName("E_Pic_URL") var picture: String? = null,
    @SerializedName("E_Geo") var geo: String? = null,
    @SerializedName("E_Info") var description: String? = null,
    @SerializedName("E_no") var no: String? = null,
    @SerializedName("E_Category") var category: String? = null,
    @SerializedName("E_Name") var name: String = "",
    @SerializedName("E_Memo") var memo: String? = null,
    @SerializedName("_id") var id: Long? = null,
    @SerializedName("E_URL") var url: String? = null
): Parcelable {

    fun getBreakTimeInfo(context: Context): String {
        return if(memo.isNullOrBlank()) {
            context.getString(R.string.no_break_time_data)
        } else{
            memo!!
        }
    }
}


