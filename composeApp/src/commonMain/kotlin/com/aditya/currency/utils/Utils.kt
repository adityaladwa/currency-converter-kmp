package com.aditya.currency.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import currency_converter.composeapp.generated.resources.Res
import currency_converter.composeapp.generated.resources.bebas_nue_regular
import org.jetbrains.compose.resources.Font

@Composable
fun GetBebasFontFamily() = FontFamily(Font(Res.font.bebas_nue_regular))
