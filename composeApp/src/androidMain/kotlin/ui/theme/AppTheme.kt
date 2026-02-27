package com.example.minercineplex.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MinerTheme(content: @Composable () -> Unit) {

    val darkScheme = darkColorScheme(
        primary = Color(0xFFFFB800),
        background = Color.Black,
        surface = Color(0xFF1C1C1C)
    )

    MaterialTheme(
        colorScheme = darkScheme,
        content = content
    )
}