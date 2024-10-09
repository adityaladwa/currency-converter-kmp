package com.aditya.currency.data.remote

import com.aditya.currency.domain.CurrencyAPIService
import com.aditya.currency.domain.Response
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLBuilder
import io.ktor.http.appendEncodedPathSegments
import io.ktor.http.isSuccess

private const val BASE_URL =
    "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1"

class RealCurrencyAPIService(
    private val client: HttpClient
) : CurrencyAPIService {

    override suspend fun getCurrency(symbol: String): Response<SymbolResponseDTO> {
        val url = URLBuilder(BASE_URL).appendEncodedPathSegments(
            "currencies",
            "${symbol.lowercase()}.json"
        ).build()
        val response = client.get(url)
        if (response.status.isSuccess()) {
            return Response.Success(response.body())
        }
        return Response.Error(response.body())
    }
}