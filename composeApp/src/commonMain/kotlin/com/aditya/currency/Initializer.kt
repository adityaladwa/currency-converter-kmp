package com.aditya.currency

import com.aditya.currency.di.appModule
import com.aditya.currency.di.viewModelModule
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.core.context.startKoin

object Initializer {

    fun initAll() {
        initLogs()
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            modules(appModule, viewModelModule)
        }
    }

    private fun initLogs() {
        Napier.base(DebugAntilog())
    }
}