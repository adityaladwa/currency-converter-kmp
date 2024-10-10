package com.aditya.currency.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.currency.data.remote.SymbolResponseDTO
import com.aditya.currency.domain.CurrencyAPIService
import com.aditya.currency.domain.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val api: CurrencyAPIService
) : ViewModel() {

    fun getRate(fromSymbol: String, toSymbol: String): StateFlow<Response<SymbolResponseDTO>> {
        return flow {
            emit(api.getCurrency(fromSymbol))
        }.flowOn(Dispatchers.IO)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = Response.Loading
            )
    }
}