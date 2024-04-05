package com.szlaki.turystyczne.ui

import com.szlaki.turystyczne.Trail

data class TrailUiState(
    val trail: Trail = Trail(),
    val IsTimerStarted: Boolean = false,
//    val timer
//    itp, itd
)
