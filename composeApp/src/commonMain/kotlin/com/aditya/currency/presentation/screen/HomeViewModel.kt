package com.aditya.currency.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.currency.domain.CurrencyAPIService
import com.aditya.currency.domain.Response
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val api: CurrencyAPIService
) : ViewModel() {

    fun getRate(fromSymbol: String, toSymbol: String): StateFlow<String> {
        return flow {
            when (val response = api.getCurrency(fromSymbol)) {
                is Response.Error -> emit(response.error.message.toString())
                is Response.Success -> emit(response.data.currency[toSymbol].toString())
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ""
        )
    }
}