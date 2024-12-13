package models

// TimerModelProvider.kt
import androidx.compose.runtime.compositionLocalOf

val TimerModelProvider = compositionLocalOf<TimerModel> { error("No TimerModel found!") }
