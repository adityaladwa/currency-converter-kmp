package com.aditya.currency.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aditya.currency.domain.CurrencyType
import com.aditya.currency.domain.Response
import io.github.aakira.napier.Napier
import org.koin.compose.viewmodel.koinViewModel
import kotlin.math.round

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel(),
    onClickCurrencyType: (currencyType: CurrencyType) -> Unit
) {
    val rateFlow = remember { homeViewModel.getRate("usd", "inr") }
    val response by rateFlow.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeHeader { onClickCurrencyType(it) }
        when (val res = response) {
            is Response.Error -> Napier.e("Error fetching currency", res.error)
            Response.Loading -> Napier.d("Loading")
            is Response.Success -> {
                val fromRateRounded = round(res.data.currency["inr"]?.times(1000) ?: 0.00) / 1000
                val toRate = fromRateRounded.let { 1.00.div(fromRateRounded) }
                val toRateRounded = round(toRate * 1000) / 1000
                val convertedAmountRounded = round(fromRateRounded.times(20.00) * 1000) / 1000
                ConversionText(
                    convertedAmountRounded.toString(),
                    fromRateRounded.toString(),
                    toRateRounded.toString()
                )
            }
        }
    }
}