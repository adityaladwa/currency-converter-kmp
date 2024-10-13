package com.aditya.currency.presentation.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aditya.currency.utils.GetBebasFontFamily
import io.github.aakira.napier.Napier

@Composable
fun ConversionText(
    convertedAmount: String,
    fromRate: String,
    toRate: String,
    isConvertedAmountVisible: Boolean
) {
    Napier.d { "ConversionText $convertedAmount $fromRate $toRate" }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .imePadding()
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(
                visible = isConvertedAmountVisible,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = convertedAmount,
                    fontSize = 60.sp,
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    fontFamily = GetBebasFontFamily()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = fromRate,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = toRate,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        }
        Button(
            modifier = Modifier.fillMaxWidth()
                .height(54.dp)
                .padding(horizontal = 24.dp)
                .background(
                    color = Color.Unspecified,
                    shape = RoundedCornerShape(99.dp)
                ),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            )
        ) {
            Text("Convert")
        }
    }
}