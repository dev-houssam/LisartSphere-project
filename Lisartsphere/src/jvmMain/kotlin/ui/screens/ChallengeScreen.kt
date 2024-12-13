
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import models.TimerModel

@Composable
@Preview
fun ChallengeScreen(timerModel: MutableState<TimerModel>) {
        Column(
                modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
        ) {
                // Section pour des informations ou un challenge
                Row(
                        modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {


                }

                Spacer(modifier = Modifier.height(16.dp))

                AffichageLecteurPDF(timerModel)
        }
}


@Composable
fun AffichageLecteurPDF(timerModel: MutableState<TimerModel>){
        // Section Lecteur PDF
        Row(
                modifier = Modifier
                        .fillMaxSize()
                        .background(
                                Brush.linearGradient(
                                        colors = listOf(
                                                Color(0xFFFFFFFF), // Blanc
                                                Color(0xFFF5F5F5),
                                                Color(0xFFFFFFFF),// Gris très clair
                                                Color(0xFFE3F2FD), // Vert
                                                Color(0x00F000F0),  // Orange
                                                Color(0xFFFFFFFF),
                                        ),
                                            // Définir le point de fin du dégradé
                                )
                        )
                        .graphicsLayer {
                                shadowElevation = 400.dp.toPx() // Ajouter un léger effet de flou
                                shape = RoundedCornerShape(110.dp) // Arrondir les coins si nécessaire
                                clip = true
                        },
                horizontalArrangement = Arrangement.SpaceBetween
        ) {
                Box(
                        modifier = Modifier

                                .weight(2f)
                                .fillMaxHeight(5f)
                ) {
                        TimerApp(timerModel)
                }


                Box(
                        modifier = Modifier
                                .weight(4f)

                                .padding(end = 30.dp)
                ) {
                        PreviewOnePagePdfReader(
                                "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/pomme.pdf"
                        )
                }


        }
}