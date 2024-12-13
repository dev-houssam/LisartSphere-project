

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import models.TimerModel
import ui.components.Sidebar

@Composable
@Preview
fun App() {
    var selectedTab by remember { mutableStateOf("accueil") }
    val timerModel = remember { mutableStateOf(TimerModel(300)) } // L'état du Timer
    Row {
        Sidebar { selectedTab = it }
        MainContent(selectedTab, timerModel) { selectedTab = it }
    }
}


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Lisartsphere",
        state = androidx.compose.ui.window.WindowState(width = 950.dp, height = 650.dp)
    ) {
        App()

        // Accéder à la fenêtre native pour définir une taille minimale
        window.minimumSize = java.awt.Dimension(950, 300)
    }
}