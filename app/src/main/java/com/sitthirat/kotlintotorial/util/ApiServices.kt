package com.sitthirat.kotlintotorial.util

import com.google.gson.Gson
import com.sitthirat.kotlintotorial.model.Model
import retrofit2.Call
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Prew on 6/19/2017.
 */
object ApiServices {

    var endpointInterface = init()

    private fun init() : EndpointInterface {
    val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://nuuneoi.com/courses/500px/")
            .build()

        val endpointInterface:EndpointInterface = retrofit.create(EndpointInterface::class.java)

        return endpointInterface
    }

    interface EndpointInterface {

        @POST("list")
        fun getListItem(): Call<Model.ListModel>
    }
}
