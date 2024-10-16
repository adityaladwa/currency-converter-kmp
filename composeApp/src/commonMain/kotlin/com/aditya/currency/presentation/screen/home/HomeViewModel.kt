package com.aditya.currency.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.currency.data.remote.SymbolResponseDTO
import com.aditya.currency.domain.CurrencyAPIService
import com.aditya.currency.domain.CurrencyCode
import com.aditya.currency.domain.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlin.math.round

class HomeViewModel(
    private val api: CurrencyAPIService
) : ViewModel() {

    private val _sourceCurrencyCode = MutableStateFlow(CurrencyCode.USD)
    private val _targetCurrencyCode = MutableStateFlow(CurrencyCode.INR)

    val sourceCurrencyCode =
        _sourceCurrencyCode
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = CurrencyCode.USD
            )
    val targetCurrencyCode =
        _targetCurrencyCode
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = CurrencyCode.USD
            )

    @OptIn(ExperimentalCoroutinesApi::class)
    val rateFlow: StateFlow<Response<SymbolResponseDTO>> =
        combine(_sourceCurrencyCode) { source ->
            source
        }.flatMapLatest {
            flow {
                emit(Response.Loading)
                val fromSymbol = _sourceCurrencyCode.value.name
                emit(api.getCurrency(fromSymbol))
            }.flowOn(Dispatchers.IO)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = Response.Loading
        )


    fun setSourceCurrency(currencyCode: CurrencyCode) {
        _sourceCurrencyCode.update { currencyCode }
    }

    fun setTargetCurrency(currencyCode: CurrencyCode) {
        _targetCurrencyCode.update { currencyCode }
    }

    fun convertToString(
        response: Response.Success<SymbolResponseDTO>,
        amount: Double
    ): ConvertedAmount {
        val fromRateRounded = round(
            response.data.currency[targetCurrencyCode.value.name.lowercase()]?.times(1000) ?: 0.00
        ) / 1000
        val toRate = fromRateRounded.let { 1.00.div(fromRateRounded) }
        val toRateRounded = round(toRate * 1000) / 1000
        val convertedAmountRounded = round(fromRateRounded.times(amount) * 1000) / 1000
        return ConvertedAmount(
            convertedAmountRounded,
            "1 ${sourceCurrencyCode.value.name} = $toRateRounded ${targetCurrencyCode.value.name}",
            "1 ${targetCurrencyCode.value.name} = $fromRateRounded ${sourceCurrencyCode.value.name}"
        )
    }

    data class ConvertedAmount(
        val convertedAmountRounded: Double,
        val fromRateRounded: String,
        val toRateRounded: String
    )
}