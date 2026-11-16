package com.tonelab.ai.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.tonelab.ai.ui.theme.ToneColors

private val tabs = listOf("Home", "Analyze", "Presets", "Palette", "Settings")
private val tabIcons = listOf("⌂", "◎", "❖", "◐", "⚙")

@Composable
fun AppNav() {
    var selected by remember { mutableIntStateOf(0) }

    Scaffold(
        containerColor = ToneColors.Background,
        bottomBar = {
            NavigationBar(containerColor = ToneColors.Surface) {
                tabs.forEachIndexed { index, label ->
                    NavigationBarItem(
                        selected = selected == index,
                        onClick = { selected = index },
                        icon = { Text(tabIcons[index]) },
                        label = { Text(label) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = ToneColors.Purple,
                            selectedTextColor = ToneColors.Purple,
                            unselectedIconColor = ToneColors.TextSecondary,
                            unselectedTextColor = ToneColors.TextSecondary,
                            indicatorColor = ToneColors.SurfaceHigh
                        )
                    )
                }
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Crossfade(targetState = selected, label = "tab") { page ->
                when (page) {
                    0 -> HomeScreen(onAnalyzeClick = { selected = 1 })
                    1 -> PlaceholderScreen(
                        "Analyze",
                        "Pemilih foto dan hasil analisis akan dibuat di Tahap 3 dan 4."
                    )
                    2 -> PlaceholderScreen(
                        "Presets",
                        "Perpustakaan preset akan dibuat di Tahap 8."
                    )
                    3 -> PlaceholderScreen(
                        "Palette",
                        "Pendeteksi palet warna akan dibuat di Tahap 4."
                    )
                    else -> PlaceholderScreen(
                        "Settings",
                        "Pengaturan, privasi, dan hapus data akan dibuat di Tahap 9."
                    )
                }
            }
        }
    }
}
