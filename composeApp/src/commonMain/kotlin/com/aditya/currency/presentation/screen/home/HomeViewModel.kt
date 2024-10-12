package com.aditya.currency.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.currency.data.remote.SymbolResponseDTO
import com.aditya.currency.domain.CurrencyAPIService
import com.aditya.currency.domain.CurrencyCode
import com.aditya.currency.domain.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn

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

    fun getRate(): StateFlow<Response<SymbolResponseDTO>> {
        val fromSymbol = _sourceCurrencyCode.value.name
        return flow {
            emit(api.getCurrency(fromSymbol))
        }.flowOn(Dispatchers.IO)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = Response.Loading
            )
    }

    fun setSourceCurrency(currencyCode: CurrencyCode) {
        _sourceCurrencyCode.value = currencyCode
    }

    fun setTargetCurrency(currencyCode: CurrencyCode) {
        _targetCurrencyCode.value = currencyCode
    }
}