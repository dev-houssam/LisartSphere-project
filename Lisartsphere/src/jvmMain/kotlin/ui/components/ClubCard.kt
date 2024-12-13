package ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import models.ClubLecture




@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClubCard(club : ClubLecture, modifier: Modifier) {
    println("Tick")
    Card(
         // Appeler la fonction de clic avec le livre sélectionné
        modifier = Modifier.width(500.dp).height(500.dp).background(
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
                shadowElevation = 10.dp.toPx() // Ajouter un léger effet de flou
                shape = RoundedCornerShape(200.dp) // Arrondir les coins si nécessaire
                clip = true
            }
    ) {
        Column(
            modifier = Modifier
                .width(100.dp)
                .padding(16.dp)
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFFFFFF), // Blanc
                            Color(0xFFF5F5F5),
                            Color(0xFFFFFFFF),// Gris très clair
                            Color(0xFFE3F2FD), // Vert
                            Color(0x00F000F0),  // Orange
                            Color(0xFFF5F5F5),
                        ),
                        // Définir le point de fin du dégradé
                    )
                )
        ) {
            Image(
                painter = painterResource("path_to_image.jpg"),
                contentDescription = club.nom,
                modifier = Modifier. size(150.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(start = 15.dp)) {
                /*Text(book.title+"\nBeaucoup",
                    style = MaterialTheme.typography.h6,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    modifier = Modifier.wrapContentWidth().padding(4.dp)
                )*/
                DynamicText(club.nom, 250, MaterialTheme.typography.h6)
                Divider()
                Text(club.description, style = MaterialTheme.typography.body2)
            }
        }
    }
}




/*
@Composable
fun AfficheLecteur(){
    println("Yes")
    PreviewPdfReader("/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/pomme.pdf")

}*/

