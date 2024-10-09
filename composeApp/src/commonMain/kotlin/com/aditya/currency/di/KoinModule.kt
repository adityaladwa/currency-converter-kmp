package com.aditya.currency.di

import com.aditya.currency.screen.HomeViewModel
import com.aditya.currency.data.remote.RealCurrencyAPIService
import com.aditya.currency.domain.CurrencyAPIService
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.v(tag = "Ktor", message = message)
                    }
                }
            }
        }
    }
    single<CurrencyAPIService> { RealCurrencyAPIService(get()) }
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