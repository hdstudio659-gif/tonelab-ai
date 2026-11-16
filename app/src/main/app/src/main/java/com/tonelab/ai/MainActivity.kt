package com.tonelab.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tonelab.ai.ui.AppNav
import com.tonelab.ai.ui.theme.ToneLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToneLabTheme {
                AppNav()
            }
        }
    }
}
