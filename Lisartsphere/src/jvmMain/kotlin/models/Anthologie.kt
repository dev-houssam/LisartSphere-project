package models


import Book
import java.time.LocalDateTime

data class Anthologie(
    val id: String, // Identifiant unique
    val title: String, // Titre de l'anthologie
    val description: String, // Description ou résumé de l'anthologie
    val citations: List<Citation>, // Liste des citations contenues
    val createdAt: String, // Date de création
    val updatedAt: String, // Dernière mise à jour
    val author: String // Auteur ou compilateur de l'anthologie
)

val anthologieData = listOf(
    Anthologie(
        id = "1",
        title = "Anthologie de la Philosophie",
        description = "Une collection des plus grandes citations philosophiques qui marquent l'histoire de la pensée.",
        citations = listOf(
            Citation(
                id = "1",
                book = Book(
                    id = 1,
                    title = "L'Être et le Néant",
                    author = "Jean-Paul Sartre",
                    genre = "Philosophie",
                    status = "Lu",
                    path = "pomme.pdf",
                    cover = "https://example.com/etre-et-neant.jpg",
                    addedDate = "2025"
                ),
                title = "Liberté et Condamnation",
                text = "L'homme est condamné à être libre.",
                author = "Jean-Paul Sartre",
                createdAt = LocalDateTime.now().minusDays(5),
                status = Status.READ
            ),
            Citation(
                id = "2",
                book = null,
                title = "Le Destin",
                text = "Ce qui doit arriver arrivera, même si personne n'y croit.",
                author = "Marc Aurèle",
                createdAt = LocalDateTime.now().minusMonths(1),
                status = Status.TO_READ
            )
        ),
        createdAt = "2024-11-30",
        updatedAt = "2024-12-02",
        author = "Houssam Bacar"
    ),
    Anthologie(
        id = "2",
        title = "Anthologie Littéraire",
        description = "Une collection des plus belles citations issues des chefs-d'œuvre de la littérature mondiale.",
        citations = listOf(
            Citation(
                id = "3",
                book = Book(
                    id = 2,
                    title = "Le Petit Prince",
                    author = "Antoine de Saint-Exupéry",
                    genre = "Fiction",
                    status = "Lu",
                    path = "pomme.pdf",
                    cover = "https://example.com/le-petit-prince.jpg",
                    addedDate = "2026"
                ),
                title = "Voir avec le cœur",
                text = "On ne voit bien qu'avec le cœur. L'essentiel est invisible pour les yeux.",
                author = "Antoine de Saint-Exupéry",
                createdAt = LocalDateTime.now().minusDays(10),
                status = Status.FAVORITE
            )
        ),
        createdAt = "2024-12-01",
        updatedAt = "2024-12-03",
        author = "Houssam Bacar"
    )
)

