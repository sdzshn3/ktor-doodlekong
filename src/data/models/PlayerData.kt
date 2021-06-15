package com.sdzsn3.data.models

data class PlayerData(
    val username: String,
    var isDrawing: Boolean,
    var score: Int = 0,
    var rank: Int = 0
)
