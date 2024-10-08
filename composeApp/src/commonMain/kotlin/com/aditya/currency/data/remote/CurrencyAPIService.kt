package com.aditya.currency.data.remote

import com.aditya.currency.domain.CurrencyAPIService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.URLBuilder
import io.ktor.http.appendEncodedPathSegments
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL =
    "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1"

class RealCurrencyAPIService : CurrencyAPIService {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun getCurrency(symbol: String): SymbolResponseDTO {
        val url =
            URLBuilder(BASE_URL).appendEncodedPathSegments(
                "currencies",
                "${symbol.lowercase()}.json"
            ).build()
        val response = client.get(url)
        println(response.bodyAsText())
        return response.body()
    }
}