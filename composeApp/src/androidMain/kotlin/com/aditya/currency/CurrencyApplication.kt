package com.aditya.currency

import android.app.Application

class CurrencyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Initializer.initAll()
    }
}