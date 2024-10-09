package com.aditya.currency

import android.app.Application
import com.aditya.currency.di.initializeKoin

class CurrencyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin()
        initLogger()
    }
}