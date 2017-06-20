package com.sitthirat.kotlintotorial.model

import com.google.gson.annotations.SerializedName

/**
 * Created by prewsitthirat on 6/16/2017 AD.
 */

class Model {

    data class MenuModel(var menuName: List<String>?)

    data class ListModel(
            @SerializedName("success") var success: Boolean,
            @SerializedName("data") var datas: List<Data> )

    data class Data(
            @SerializedName("id") var id:Int,
            @SerializedName("image_url") var imgUrl:String,
            @SerializedName("caption") var caption:String)
}