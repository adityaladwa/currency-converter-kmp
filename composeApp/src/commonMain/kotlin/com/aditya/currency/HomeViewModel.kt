package com.aditya.currency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.currency.data.remote.RealCurrencyAPIService
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val api: RealCurrencyAPIService
) : ViewModel() {
    val greeting = Greeting().greet()

    fun getRate(symbol: String): StateFlow<String> {
        return flow { emit(api.getCurrency(symbol).currency["inr"].toString()) }
            .catch { emit("Error") }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = ""
            )
    }
}