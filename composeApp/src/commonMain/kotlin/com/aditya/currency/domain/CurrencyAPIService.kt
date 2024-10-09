package com.aditya.currency.domain

import com.aditya.currency.data.remote.SymbolResponseDTO

interface CurrencyAPIService {

    suspend fun getCurrency(symbol: String): Response<SymbolResponseDTO>
}