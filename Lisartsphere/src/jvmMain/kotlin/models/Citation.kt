package models

import Book
import java.time.LocalDateTime


data class Citation(
    val id: String, // Identifiant unique
    val book: Book? = null, // Livre associé (facultatif)
    val title: String, // Titre de la citation
    val text: String, // Texte de la citation
    val author: String, // Auteur de la citation
    val createdAt: LocalDateTime, // Date de création
    val status: Status // Statut de la citation
)

enum class Status {
    FAVORITE, // Citation favorite
    TO_READ, // À lire plus tard
    READ // Déjà lue
}


val citationData = listOf(
    Citation(
        id = "1",
        book = Book(
            id = 1,
            title = "Le Petit Prince",
            author = "Antoine de Saint-Exupéry",
            genre = "Fiction",
            status = "Lu",
            path = "pomme.pdf",
            cover = "https://example.com/le-petit-prince.jpg",
            addedDate = "2025"
        ),
        title = "Voir avec le cœur",
        text = "On ne voit bien qu'avec le cœur. L'essentiel est invisible pour les yeux.",
        author = "Antoine de Saint-Exupéry",
        createdAt = LocalDateTime.now().minusDays(10),
        status = Status.FAVORITE
    ),
    Citation(
        id = "2",
        book = null, // Pas de livre associé
        title = "La Liberté",
        text = "La liberté commence où l'ignorance finit.",
        author = "Victor Hugo",
        createdAt = LocalDateTime.now().minusDays(20),
        status = Status.TO_READ
    ),
    Citation(
        id = "3",
        book = Book(
            id = 3,
            title = "L'Être et le Néant",
            author = "Jean-Paul Sartre",
            genre = "Philosophie",
            status = "Lu",
            path = "pomme.pdf",
            cover = "https://example.com/etre-et-neant.jpg",
            addedDate = "2023"
        ),
        title = "Liberté et Condamnation",
        text = "L'homme est condamné à être libre.",
        author = "Jean-Paul Sartre",
        createdAt = LocalDateTime.now().minusDays(5),
        status = Status.READ
    )
)

