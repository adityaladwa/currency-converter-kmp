package com.aditya.currency.di

import com.aditya.currency.HomeViewModel
import com.aditya.currency.data.remote.RealCurrencyAPIService
import com.aditya.currency.domain.CurrencyAPIService
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single<CurrencyAPIService> { RealCurrencyAPIService() }
}

val viewModelModule = module {
    factory {
        HomeViewModel(get())
    }
}

fun initializeKoin() {
    startKoin {
        modules(appModule, viewModelModule)
    }
}