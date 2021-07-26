package com.marcus.cathay.data.response

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class PlantDetail(
    @SerializedName("F_Name_Latin") var nameLatin: String? = null,
    @SerializedName("\uFEFFF_Name_Ch") var nameCh: String? = null,
    @SerializedName("F_Name_En") var nameEn: String? = null,
    @SerializedName("F_Location") var location: String? = null,
    @SerializedName("F_Summary") var summary: String? = null,
    @SerializedName("F_Pic01_ALT") var pic01Alt: String? = null,
    @SerializedName("F_Pic01_URL") var picture01: String? = null,
    @SerializedName("F_Pic02_URL") var picture02: String? = null,
    @SerializedName("F_Pic03_URL") var picture03: String? = null,
    @SerializedName("F_Pic04_URL") var picture04: String? = null,
    @SerializedName("_full_count") var fullCount: String? = null,
    @SerializedName("F_Geo") var geo: String? = null,
    @SerializedName("F_AlsoKnown") var alsoKnow: String? = null,
    @SerializedName("F_Brief") var brief: String? = null,
    @SerializedName("F_Family") var family: String? = null,
    @SerializedName("F_Genus") var genus: String? = null,
    @SerializedName("F_Function＆Application") var function: String? = null,
    @SerializedName("F_Update") var update: String? = null,
    @SerializedName("F_Feature") var feature: String? = null
): Parcelable
//    "F_Name_Latin":"Lagerstroemia subcostata",
//    "F_pdf02_ALT":"",
//    "F_Location":"臺灣動物區；蟲蟲探索谷；熱帶雨林區；鳥園；兩棲爬蟲動物館",
//    "F_pdf01_ALT":"",
//    "rank":0.0573088,
//    "F_Summary":"",
//    "F_Pic01_URL":"http://www.zoo.gov.tw/iTAP/04_Plant/Lythraceae/subcostata/subcostata_1.jpg",
//    "_full_count":"102",
//    "F_pdf02_URL":"",
//    "F_Pic02_URL":"",
//    "F_Name_Ch":"九芎",
//    "F_Keywords":"",
//    "F_Code":"",
//    "F_Geo":"MULTIPOINT ((121.5804577 24.9979216), (121.5805328 24.9959671), (121.5836763 24.9957094), (121.5894029 24.9951126), (121.5899205 24.9945669))",
//    "F_Pic03_URL":"",
//    "F_Voice01_ALT":"",
//    "F_AlsoKnown":"苞飯花、拘那花、小果紫薇、南紫薇、猴不爬、怕癢樹、南紫薇、九荊、馬鈴花、蚊仔花",
//    "F_Voice02_ALT":"",
//    "F_Pic04_ALT":"",
//    "F_Name_En":"Subcostate Crape Myrtle",
//    "F_Brief":"分布於中低海拔森林及長江以南的地區，為台灣的原生樹種。主要生長在潮濕的崩塌地，有吸水保持土壤之特性，所以是良好的水土保持樹種。",
//    "F_Pic04_URL":"",
//    "F_Voice01_URL":"",
//    "F_Feature":"紅褐色的樹皮剝落後呈灰白色，樹幹光滑堅硬。葉有極短的柄，長橢圓形或卵形，全綠，葉片兩端尖，秋冬轉紅。夏季6～8月開花，花冠白色，花數甚多而密生於枝端，花為圓錐花序頂生，花瓣有長柄，邊緣皺曲像衣裙的花邊花絲長短不一。果實為蒴果，橢圓形約6-8公厘，種子有翅。",
//    "F_Pic02_ALT":"",
//    "F_Family":"千屈菜科 Lythraceae",
//    "F_Voice03_ALT":"",
//    "F_Voice02_URL":"",
//    "F_Pic03_ALT":"",
//    "F_Pic01_ALT":"九芎果實",
//    "F_CID":"",
//    "F_pdf01_URL":"",
//    "F_Vedio_URL":"",
//    "F_Genus":"紫薇屬Lagerstroemia",
//    "F_Function＆Application":"1. 優良薪炭材：木質堅硬耐燒，是臺灣優良的薪炭材之一。\n2. 水土保持植栽：可栽植於河岸及邊坡供水土保持。\n3. 農具用材：木質堅硬，乾燥後不太會反翹，是做農具的用材。\n4. 食用性：花、根入藥，味淡微苦，敗毒散瘀，花蕾味苦有清香，可生食。葉子是長尾水青蛾幼蟲的食草。",
//    "F_Voice03_URL":"",
//    "F_Update":"2017/9/4",
//    "_id":1


