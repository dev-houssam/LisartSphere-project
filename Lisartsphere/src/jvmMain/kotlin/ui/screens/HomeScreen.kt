import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import models.TimerModel
import ui.screens.*


@Composable
fun HomeScreen(onStartAdventure: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(
                Brush.linearGradient(
                colors = listOf(
                    Color(0xFFE3F2FD), // Bleu clair
                    Color(0xFFE3F2FF),
                    Color(0xFFF07FFF)  // Vert
                )
            )),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        // Titre principal
        Text(
            "LISARTSPHERE",
            style = MaterialTheme.typography.h1,
            color = Color(0xFF333333)
        )
        Text(
            "Lisez, en cela, Explorez, Découvrez, Inspirez-vous !",
            style = MaterialTheme.typography.subtitle1,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Cartes organisées dans une FlowRow
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFFFFFF), // Blanc
                            Color(0xFFF5F5F5), // Gris très clair
                            Color(0xFFE3F2FD)  // Vert
                        )
                    )),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FeatureCard(
                title = "Vaste Collection",
                description = "Des milliers de livres à portée de main",
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            )
            FeatureCard(
                title = "Challenge",
                description = "L'amusement au rendez-vous",
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            )
            FeatureCard(
                title = "Club de Lecture",
                description = "Partagez vos passions littéraires",
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Bouton d'action
        Button(
            onClick = onStartAdventure,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF007BFF))
        ) {
            Text("Commencer l'aventure", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun FeatureCard(title: String, description: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth(0.3f) // Définit une largeur relative pour plus de flexibilité
            .height(150.dp), // Ajustez la hauteur selon vos besoins
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(title, style = MaterialTheme.typography.h6, color = Color(0xFF444444))
            Text(description, style = MaterialTheme.typography.body2, color = Color.Gray)
        }
    }
}




@Composable
fun MainContent(
    selectedTab: String,
    timerModel: MutableState<TimerModel>,
    onTabSelected: (String) -> Unit
) {
    when (selectedTab) {
        "accueil" -> HomeScreen { onTabSelected("bibliotheque") }
        "bibliotheque" -> LibraryScreen()
        "challenge" -> ChallengeScreen(timerModel)
        "organisation" -> OrganizationScreen()

        "citations" -> CitationsScreen()
        "club" -> ClubScreen()
        "profil" -> ProfileScreen()
        "lecteur" -> LecteurScreen()
    }
}


