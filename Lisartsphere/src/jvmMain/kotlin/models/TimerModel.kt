package models

// TimerModel.kt
data class TimerModel(
    val timerValue: Int = 0,
    val isRunning: Boolean = false, // Propriété indiquant si le timer est en cours d'exécution
    val showConfetti: Boolean = false // Propriété pour afficher ou non les confettis
)