package com.aditya.currency.data.remote

import com.aditya.currency.domain.CurrencyAPIService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLBuilder
import io.ktor.http.appendEncodedPathSegments

private const val BASE_URL =
    "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1"

class RealCurrencyAPIService(
    private val client: HttpClient
) : CurrencyAPIService {

    override suspend fun getCurrency(symbol: String): SymbolResponseDTO {
        val url = URLBuilder(BASE_URL).appendEncodedPathSegments(
            "currencies",
            "${symbol.lowercase()}.json"
        ).build()
        val response = client.get(url)
        return response.body()
    }
}