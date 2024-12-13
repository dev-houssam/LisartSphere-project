package models


/*
data class ResumeCollection(
    val resumes: List<Resume>, // Liste des résumés
    val totalResumes: Int, // Nombre total de résumés
    val mostPopularResume: Resume?, // Résumé le plus populaire (basé sur les interactions, par exemple)
    val recentResumes: List<Resume> // Résumés récemment ajoutés/modifiés
)*/

import models.*
/*
val user1 = User("1", "Houssam", "Bacar", "houssam@example.com", "Mahorais", "France", "2001-01-01")
val user2 = User("2", "Sarah", "Doe", "sarah@example.com", "Anglaise", "France", "2023-12-01")


val user1 = User( 1, "", "", "",
    0,
    0,
    0,
    "f",
    0,0)

val user2 = User( 1, "", "", "",
    0,
    0,
    0,
    "f",
    0,0)


/*
val book1 = Book(1, "Le Petit Prince", "Antoine de Saint-Exupéry", "Fiction", "Lu", "path_to_image.jpg", "")
val book2 = Book(2, "1984", "George Orwell", "Science-Fiction", "Lu", "path_to_image.webp", "")
*/

val book1 = Book(1, "", "", "", "n", "", "")
val book2 = Book(1, "", "", "", "n", "", "")


val resume1 = Resume(
    id = "1",
    title = "Résumé du Petit Prince",
    content = "Le Petit Prince raconte l'histoire d'un jeune prince voyageant à travers différentes planètes...",
    book = book1,
    author = user1,
    createdAt = "2024-01-15",
    updatedAt = null,
    status = "Public"
)

val resume2 = Resume(
    id = "2",
    title = "Analyse de 1984",
    content = "1984 est un roman dystopique de George Orwell qui explore les thèmes de la surveillance et de la liberté...",
    book = book2,
    author = user2,
    createdAt = "2023-12-20",
    updatedAt = "2024-01-10",
    status = "Privé"
)

val resume3 = Resume(
    id = "3",
    title = "Les métaphores dans Le Petit Prince",
    content = "Une analyse approfondie des métaphores utilisées dans le livre Le Petit Prince...",
    book = book1,
    author = user1,
    createdAt = "2024-01-18",
    updatedAt = "2024-01-19",
    status = "Public"
)

val resumeCollection = ResumeCollection(
    resumes = listOf(resume1, resume2, resume3),
    totalResumes = 3,
    mostPopularResume = resume1, // Supposons que ce résumé est le plus populaire
    recentResumes = listOf(resume3, resume2) // Résumés récemment ajoutés ou mis à jour
)

*/