package com.aditya.currency

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    initLogger()
    App()
}