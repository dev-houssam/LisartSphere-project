package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Sidebar(onTabSelected: (String) -> Unit = {}) {
    // Liste des onglets avec leurs icônes
    val tabs = listOf(
        "Accueil" to Icons.Filled.Home,
        "Bibliothèque" to Icons.Filled.List,
        "Challenge" to Icons.Filled.Star,
        "Organisation" to Icons.Filled.Create,
        "Citations" to Icons.Filled.ThumbUp,
        "Club" to Icons.Filled.Favorite,
        "Profil" to Icons.Filled.Person
    )

    // État pour suivre l'onglet actuellement sélectionné
    var selectedTab by remember { mutableStateOf(tabs[0].first) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
            .background(MaterialTheme.colors.surface)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Titre
        Text(
            text = "- LISARTSPHERE -\n  Bonne Lecture",
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(horizontal = 1.dp)
        )
        Divider(color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f), thickness = 1.dp)

        Spacer(modifier = Modifier.height(16.dp))

        // Affichage des onglets
        tabs.forEach { (tabName, icon) ->
            val isSelected = tabName == selectedTab // Vérifie si cet onglet est sélectionné

            Button(
                onClick = {
                    selectedTab = tabName // Met à jour l'onglet sélectionné
                    onTabSelected(tabName.lowercase().replace('é', 'e').replace('è', 'e'))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                colors = ButtonDefaults.buttonColors(
                    //MaterialTheme.colors.primary
                    //MaterialTheme.colors.primary.copy(alpha = 0.1f)
                    backgroundColor = if (isSelected) Color(255, 255, 255) else Color(255,255,255),
                    contentColor = if (isSelected) Color(0, 0, 0) else MaterialTheme.colors.primary
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = tabName,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}
