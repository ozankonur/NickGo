package com.okonur.nickgo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NickGoApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}