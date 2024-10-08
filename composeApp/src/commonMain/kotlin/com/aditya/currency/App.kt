package com.aditya.currency

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aditya.currency.data.remote.RealCurrencyAPIService
import com.aditya.currency.domain.CurrencyAPIService
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val api: CurrencyAPIService = remember { RealCurrencyAPIService() }
    LaunchedEffect(Unit) {
        val symbol = api.getCurrency("USD")
        println("INR = ${symbol.currency["inr"]}")
    }
    MaterialTheme {
        val homeViewModel = remember { HomeViewModel() }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                text = homeViewModel.greeting,
            )
        }
    }
}