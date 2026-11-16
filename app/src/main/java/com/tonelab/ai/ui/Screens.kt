package com.tonelab.ai.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tonelab.ai.ui.theme.ToneColors

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        color = ToneColors.TextPrimary,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(top = 24.dp, bottom = 10.dp)
    )
}

@Composable
private fun PlaceholderCard(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(ToneColors.Surface)
            .padding(20.dp)
    ) {
        Text(text = text, color = ToneColors.TextSecondary, fontSize = 14.sp)
    }
}

@Composable
fun HomeScreen(onAnalyzeClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Text(
            text = "TONE LAB AI",
            color = ToneColors.TextPrimary,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Analyze. Create. Export. Repeat.",
            color = ToneColors.TextSecondary,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
        Spacer(Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(ToneColors.Gradient)
                .clickable { onAnalyzeClick() }
                .padding(vertical = 22.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Analyze Your Photo",
                color = ToneColors.TextPrimary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        SectionTitle("Recent Presets")
        PlaceholderCard("Belum ada preset. Preset yang Anda buat akan muncul di sini.")
        SectionTitle("Preset Favorites")
        PlaceholderCard("Belum ada favorit.")
        SectionTitle("Riwayat Analisis")
        PlaceholderCard("Belum ada riwayat analisis.")
    }
}

@Composable
fun PlaceholderScreen(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = title,
            color = ToneColors.TextPrimary,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        PlaceholderCard(description)
    }
}
