package com.szlaki.turystyczne

sealed class Screen(val route: String) {
    object Home   : Screen("home")
    object Second : Screen("second")
}