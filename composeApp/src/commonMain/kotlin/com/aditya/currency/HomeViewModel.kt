package com.aditya.currency

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val greeting = Greeting().greet()
}