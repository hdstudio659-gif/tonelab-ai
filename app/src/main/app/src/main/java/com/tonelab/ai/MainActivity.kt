package com.tonelab.ai

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tonelab.ai.ui.AppNav
import com.tonelab.ai.ui.theme.ToneLabTheme
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val crashFile = File(filesDir, "crash.txt")

        if (crashFile.exists()) {
            val report = crashFile.readText()
            crashFile.delete()
            val tv = TextView(this)
            tv.text = "ERROR TERAKHIR:\n\n" + report
            tv.setTextColor(Color.WHITE)
            tv.textSize = 11f
            tv.setPadding(32, 96, 32, 32)
            tv.setTextIsSelectable(true)
            val sv = ScrollView(this)
            sv.setBackgroundColor(Color.BLACK)
            sv.addView(tv)
            setContentView(sv)
            return
        }

        Thread.setDefaultUncaughtExceptionHandler { _, e ->
            try {
                crashFile.writeText(Log.getStackTraceString(e))
            } catch (_: Throwable) {
            }
            android.os.Process.killProcess(android.os.Process.myPid())
            System.exit(10)
        }

        setContent {
            ToneLabTheme {
                AppNav()
            }
        }
    }
}
