package com.aditya.currency.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aditya.currency.domain.Response
import com.aditya.currency.presentation.component.ConversionText
import com.aditya.currency.presentation.component.HomeHeader
import io.github.aakira.napier.Napier
import org.koin.compose.viewmodel.koinViewModel
import kotlin.math.round

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel()
) {
    val rateFlow = remember { homeViewModel.getRate("usd", "inr") }
    val response by rateFlow.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeHeader()
        when (val res = response) {
            is Response.Error -> Napier.e("Error fetching currency", res.error)
            Response.Loading -> Napier.d("Loading")
            is Response.Success -> {
                val fromRate = round(res.data.currency["inr"]?.times(1000) ?: 0.00) / 1000
                val toRate = fromRate.let { 1.00.div(fromRate) }
                val toRateRounded = round(toRate * 1000) / 1000
                val convertedAmount = fromRate.times(20.00)
                ConversionText(
                    convertedAmount.toString(),
                    fromRate.toString(),
                    toRateRounded.toString()
                )
            }
        }
    }
}