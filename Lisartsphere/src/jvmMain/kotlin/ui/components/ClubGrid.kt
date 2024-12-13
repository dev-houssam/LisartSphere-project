package ui.components


import Book
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import models.ClubLecture
import models.User

// Création d'utilisateurs fictifs
val user1 = User(
    id = 1,
    title = "Le Petit Prince",
    author = "Antoine de Saint-Exupéry",
    genre = "Fiction",
    cover = "https://example.com/img/le_petit_prince.jpg", // URL de l'image de couverture
    status = "Disponible", // Le statut du livre
    addedDate = "2024-12-10T10:00:00" // Date d'ajout au système
)
val user2 = User(
    id = 2,
    title = "Le Petit Prince",
    author = "Antoine de Saint-Exupéry",
    genre = "Fiction",
    cover = "https://example.com/img/le_petit_prince.jpg", // URL de l'image de couverture
    status = "Disponible", // Le statut du livre
    addedDate = "2024-12-10T10:00:00" // Date d'ajout au système
)
val user3 = User(
    id = 3,
    title = "Le Petit Prince",
    author = "Antoine de Saint-Exupéry",
    genre = "Fiction",
    cover = "https://example.com/img/le_petit_prince.jpg", // URL de l'image de couverture
    status = "Disponible", // Le statut du livre
    addedDate = "2024-12-10T10:00:00" // Date d'ajout au système
)


// Création de livres fictifs
val book1 = Book(
    id = 1,
    title = "1984",
    author = "George Orwell",
    genre = "Dystopie",
    path = "https://example.com/books/1984.pdf", // Chemin vers le fichier du livre
    cover = "https://example.com/img/1984.jpg", // URL de l'image de couverture
    status = "Disponible", // Le statut du livre
    addedDate = "2024-12-10T12:00:00" // Date d'ajout du livre au système
)
val book2 = Book(
    id = 2,
    title = "1984",
    author = "George Orwell",
    genre = "Dystopie",
    path = "https://example.com/books/1984.pdf", // Chemin vers le fichier du livre
    cover = "https://example.com/img/1984.jpg", // URL de l'image de couverture
    status = "Disponible", // Le statut du livre
    addedDate = "2024-12-10T12:00:00" // Date d'ajout du livre au système
)
val book3 = Book(
    id = 3,
    title = "1984",
    author = "George Orwell",
    genre = "Dystopie",
    path = "https://example.com/books/1984.pdf", // Chemin vers le fichier du livre
    cover = "https://example.com/img/1984.jpg", // URL de l'image de couverture
    status = "Disponible", // Le statut du livre
    addedDate = "2024-12-10T12:00:00" // Date d'ajout du livre au système
)

// Création du club de lecture fictif
val clubList = listOf(
    ClubLecture(
        id = "1",
        nom = "Intellect LittérActe",
        description = "Un club dédié aux amoureux de la lecture, où nous échangeons nos impressions sur les livres et organisons des discussions.",
        membre = listOf(user1, user2, user3),
        books = listOf(book1, book2, book3),
        meetingSchedule = "Tous les samedis à 15h",
        createdAt = "2024-12-10T10:00:00",
        updatedAt = "2024-12-10T12:00:00",
        creator = user1
    ),
    ClubLecture(
        id = "1",
        nom = "ChouchouLect",
        description = "Un club dédié aux amoureux de la lecture, où nous échangeons nos impressions sur les livres et organisons des discussions.",
        membre = listOf(user1, user2, user3),
        books = listOf(book1, book2, book3),
        meetingSchedule = "Tous les samedis à 15h",
        createdAt = "2024-12-10T10:00:00",
        updatedAt = "2024-12-10T12:00:00",
        creator = user1
    ),
    ClubLecture(
        id = "1",
        nom = "ClubMisticx",
        description = "Un club dédié aux amoureux de la lecture, où nous échangeons nos impressions sur les livres et organisons des discussions.",
        membre = listOf(user1, user2, user3),
        books = listOf(book1, book2, book3),
        meetingSchedule = "Tous les samedis à 15h",
        createdAt = "2024-12-10T10:00:00",
        updatedAt = "2024-12-10T12:00:00",
        creator = user1
    ),
    ClubLecture(
        id = "1",
        nom = "PommeClub",
        description = "Un club dédié aux amoureux de la lecture, où nous échangeons nos impressions sur les livres et organisons des discussions.",
        membre = listOf(user1, user2, user3),
        books = listOf(book1, book2, book3),
        meetingSchedule = "Tous les samedis à 15h",
        createdAt = "2024-12-10T10:00:00",
        updatedAt = "2024-12-10T12:00:00",
        creator = user1
    )
)


@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun ClubeGrid() {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(clubList) { club->
            Row {
                println(club)
                ClubCard(club, modifier = Modifier)
            }
        }
    }
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ClubGrid() {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 180.dp), // Ajuste dynamiquement les colonnes
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(clubList) { club ->
                ClubCard(
                    club = club,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(80f) // Contrôle la taille des cartes
                )
            }
        }
}
