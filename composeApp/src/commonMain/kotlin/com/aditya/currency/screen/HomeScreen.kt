package com.aditya.currency.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aditya.currency.getPlatform
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen() {
    val homeViewModel = koinViewModel<HomeViewModel>()
    val rateFlow = remember { homeViewModel.getRate("usd") }
    val rate by rateFlow.collectAsState()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
    ) {
        Text(
            text = rate.ifBlank { "Hello, ${getPlatform()}" },
        )
    }
}