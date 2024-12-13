
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import models.TimerModel

/*
*
On veut permettre de garder le chronometre en cours de fonctionnement même lorsqu'on sort de l'onglet !
* Pour cela on va concevoir un modele et qu'on va instancier an tant que remember mutateStateOf
* Mais du coup il faudra le faire passer en parametre pour tout garder en persistance.
* Une variable globale sera un etat globale
*
Voici les etapes :
1. Creation model TimerModel
2. Trouver la racine pour passer une instance remember de TimeModel en argument
3. Ajouter un parametre de de type mutableStateOf de TimerModel à toute les fonctions qui dependent du TimerModel
3. Implementer des action specifique pour ce TimerModel
4. Voir si le launchEffect ne cause pas de probleme !

* Voici le schema :
* TimerApp -> AffichageLecteurPDF -> ChallengeScreen -> MainContent -> App -> main

* */



@Composable
fun TimerApp(timerModel: MutableState<TimerModel>) {
    val currentModel = timerModel.value

    // L'effet lancé pour gérer le minutage
    LaunchedEffect(currentModel){
        while (currentModel.isRunning && currentModel.timerValue > 0) {
            //println("tick")
            delay(100L)
            if (currentModel.timerValue <= 1) {
                timerModel.value = currentModel.copy(
                    timerValue = currentModel.timerValue - 1,
                    isRunning = false,
                    showConfetti = true
                )
            } else {
                timerModel.value = currentModel.copy(
                    timerValue = currentModel.timerValue - 1
                )
            }

        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Affichage du timer

            Text(
                text = "Min",
                fontSize = 32.sp,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "${formatTime(currentModel.timerValue)}",
                fontSize = 32.sp,
                modifier = Modifier.padding(16.dp)
            )


        // Modification du temps
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                if (!currentModel.isRunning) {
                    timerModel.value = currentModel.copy(timerValue = currentModel.timerValue + 30)
                }
            }
            ) {
                Text("+30 sec")
            }
            Button(onClick = {
                if (!currentModel.isRunning && currentModel.timerValue >= 30) {
                    timerModel.value = currentModel.copy(timerValue = currentModel.timerValue - 30)
                }
            }) {
                Text("-30 sec")
            }
        }

        // Boutons de contrôle (Start/Pause, Reset)
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Button(onClick = {
                // Bascule de l'état de isRunning
                val updatedModel = currentModel.copy(isRunning = !currentModel.isRunning)
                timerModel.value = updatedModel
            }) {
                Text(if (currentModel.isRunning) "Pause" else "Start")
            }

            Button(onClick = {
                // Réinitialisation du modèle
                val resetModel = currentModel.copy(isRunning = false, timerValue = 300, showConfetti = false) // 5 minutes par défaut
                timerModel.value = resetModel
            }) {
                Text("Reset")
            }
        }

        // Affichage des confettis
        if (currentModel.showConfetti) {
            LaunchedEffect(Unit) {
                delay(3000) // Affichage des confettis pendant 3 secondes
                timerModel.value = currentModel.copy(showConfetti = false)
            }
            Confetti(true) // Appel de la fonction pour afficher les confettis
        }
    }
}



fun formatTime(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60
    return String.format("%02d:%02d", minutes, remainingSeconds)
}
