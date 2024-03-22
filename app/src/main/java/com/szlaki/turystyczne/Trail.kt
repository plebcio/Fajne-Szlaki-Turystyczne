package com.szlaki.turystyczne

class Trail(
    val name: String,
    val description: String,
    val length: Int = 0,
    val difficulty: Int = 0,
    val durationMin: Int = 10,
    val distanceMeter: Int = 2,
    val elevation: Int = 2,
    val imagePath: String = "xd",
    val location: String?
)
