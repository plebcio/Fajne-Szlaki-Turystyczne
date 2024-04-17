package com.szlaki.turystyczne.ui

import com.szlaki.turystyczne.Trail

data class TrailUiState(
    val trail: Trail = Trail(),
    val isTimerStarted: Boolean = false,
    val ticks: Int = 0
//    val timer
//    itp, itd
)
