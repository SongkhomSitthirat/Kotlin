package com.sitthirat.kotlintotorial

import android.app.Application
import com.sitthirat.kotlintotorial.util.Contextor

/**
 * Created by prewsitthirat on 6/16/2017 AD.
 */

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Contextor.context = applicationContext
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}