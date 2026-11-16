package com.tonelab.ai.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object ToneColors {
    val Background = Color(0xFF121214)
    val Surface = Color(0xFF1C1C21)
    val SurfaceHigh = Color(0xFF26262D)
    val Purple = Color(0xFF8B5CF6)
    val Blue = Color(0xFF3B82F6)
    val TextPrimary = Color(0xFFFFFFFF)
    val TextSecondary = Color(0xFFB0B0BA)
    val Gradient = Brush.horizontalGradient(listOf(Purple, Blue))
}

private val ToneDarkScheme = darkColorScheme(
    primary = ToneColors.Purple,
    secondary = ToneColors.Blue,
    background = ToneColors.Background,
    surface = ToneColors.Surface,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

private val ToneShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp)
)

@Composable
fun ToneLabTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ToneDarkScheme,
        shapes = ToneShapes,
        content = content
    )
}
