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

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel()
) {
    val response by remember { homeViewModel.getRate() }.collectAsState()
    val sourceCurrency by remember { homeViewModel.sourceCurrencyCode }.collectAsState()
    val targetCurrency by remember { homeViewModel.targetCurrencyCode }.collectAsState()
    var amount by remember { mutableStateOf(20.0) }
    var isConvertedAmountVisible by remember { mutableStateOf(true) }

    var openDialog by remember { mutableStateOf(false) }
    var selectedCurrencyType by remember { mutableStateOf<CurrencyType>(CurrencyType.None) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeHeader(
            amount = amount,
            source = sourceCurrency,
            target = targetCurrency,
            onClick = {
                openDialog = true
                selectedCurrencyType = it
            },
            onAmountChange = { newAmount ->
                if (newAmount != null) {
                    amount = newAmount
                    isConvertedAmountVisible = true
                } else {
                    isConvertedAmountVisible = false
                }
            }
        )
        when (val res = response) {
            is Response.Error -> Napier.e("Error fetching currency", res.error)
            Response.Loading -> Napier.d("Loading")
            is Response.Success -> {
                with(homeViewModel.convertToString(res, amount)) {
                    ConversionText(
                        convertedAmountRounded.toString(),
                        fromRateRounded,
                        toRateRounded,
                        isConvertedAmountVisible
                    )
                }
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