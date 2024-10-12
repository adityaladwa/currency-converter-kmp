package com.aditya.currency.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aditya.currency.domain.CurrencyType
import com.aditya.currency.domain.Response
import com.aditya.currency.presentation.screen.currency.CurrencyPickerDialog
import io.github.aakira.napier.Napier
import org.koin.compose.viewmodel.koinViewModel
import kotlin.math.round

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel()
) {
    val rateFlow = remember { homeViewModel.getRate() }
    val sourceCurrency = remember { homeViewModel.sourceCurrencyCode }
    val targetCurrency = remember { homeViewModel.targetCurrencyCode }
    var openDialog by remember { mutableStateOf(false) }
    var selectedCurrencyType by remember { mutableStateOf<CurrencyType>(CurrencyType.None) }
    val response by rateFlow.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeHeader(
            source = sourceCurrency,
            target = targetCurrency
        ) {
            openDialog = true
            selectedCurrencyType = it
        }
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

    if (openDialog) {
        CurrencyPickerDialog(
            onDismiss = {
                openDialog = false
            },
            currencyType = selectedCurrencyType,
            onConfirmClick = { currencyCode ->
                openDialog = false
                when (selectedCurrencyType) {
                    CurrencyType.None -> {}
                    is CurrencyType.Source -> homeViewModel.setSourceCurrency(currencyCode)
                    is CurrencyType.Target -> homeViewModel.setTargetCurrency(currencyCode)
                }
            }
        )
    }
}