package com.aditya.currency

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun isiOS(): Boolean