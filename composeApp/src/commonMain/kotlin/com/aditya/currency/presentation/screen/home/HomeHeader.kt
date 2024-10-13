package com.aditya.currency.presentation.screen.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aditya.currency.domain.CurrencyCode
import com.aditya.currency.domain.CurrencyType
import com.aditya.currency.isiOS
import currency_converter.composeapp.generated.resources.Res
import currency_converter.composeapp.generated.resources.exchange_illustration
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeHeader(
    amount: Double,
    source: CurrencyCode,
    target: CurrencyCode,
    onClick: (currencyType: CurrencyType) -> Unit,
    onAmountChange: (Double?) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .padding(all = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(if (isiOS()) 35.dp else 24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(50.dp),
                painter = painterResource(Res.drawable.exchange_illustration),
                contentDescription = "Exchange Illustration"
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
        Spacer(modifier = Modifier.height(24.dp))
        CurrencyInput(source, target) { onClick(it) }
        Spacer(modifier = Modifier.height(24.dp))
        AmountInput(amount) { d -> onAmountChange(d) }
    }
}

@Composable
fun CurrencyInput(
    source: CurrencyCode,
    target: CurrencyCode,
    onClick: (currencyType: CurrencyType) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CurrencyView(
            label = "From",
            currencyCode = source,
            onClick = { onClick(CurrencyType.Source(CurrencyCode.USD)) }
        )
        Spacer(modifier = Modifier.width(14.dp))
        CurrencyView(
            label = "To",
            currencyCode = target,
            onClick = { onClick(CurrencyType.Target(CurrencyCode.INR)) }
        )
    }
}

@Composable
fun RowScope.CurrencyView(
    label: String,
    currencyCode: CurrencyCode,
    onClick: () -> Unit
) {
    Column(modifier = Modifier.weight(1f)) {
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = label,
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(size = 8.dp))
                .background(Color.White.copy(alpha = 0.05f))
                .height(54.dp)
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(currencyCode.flag),
                tint = Color.Unspecified,
                contentDescription = "Flag"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = currencyCode.name,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun AmountInput(
    amt: Double,
    onAmountChange: (Double?) -> Unit
) {
    var amount by remember { mutableStateOf(amt.toString()) }
    TextField(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(size = 8.dp))
            .animateContentSize()
            .height(54.dp),
        value = amount,
        onValueChange = {
            amount = it
            onAmountChange(it.toDoubleOrNull())
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White.copy(alpha = 0.05f),
            unfocusedContainerColor = Color.White.copy(alpha = 0.05f),
            disabledContainerColor = Color.White.copy(alpha = 0.05f),
            errorContainerColor = Color.White.copy(alpha = 0.05f),
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.White
        ),
        textStyle = TextStyle(
            color = Color.White,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        )
    )
}