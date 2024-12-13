package ui.components


/******************************/


import Book
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import models.citationData


// Liste de livres pour l'exemple
val bookList = listOf(
    Book(
        id = 1,
        title = "Le Petit Prince",
        author = "Antoine de Saint-Exupéry",
        genre = "Philosophique, Aventure",
        path = "pomme.pdf",
        cover = "https://example.com/images/le-petit-prince.jpg",
        status = "à lire",
        addedDate = "2024-11-01"
    ),
    Book(
        id = 2,
        title = "1984",
        author = "George Orwell",
        genre = "Science-fiction, Dystopie",
        path = "pomme.pdf",
        cover = "https://example.com/images/1984.jpg",
        status = "lu",
        addedDate = "2024-10-10"
    ),
    Book(
        id = 3,
        title = "L'Alchimiste",
        author = "Paulo Coelho",
        genre = "Fiction philosophique",
        path = "pomme.pdf",
        cover = "https://example.com/images/l-alchimiste.jpg",
        status = "en cours",
        addedDate = "2024-09-15"
    ),
    Book(
        id = 4,
        title = "Les Misérables",
        author = "Victor Hugo",
        genre = "Historique, Drame",
        path = "pomme.pdf",
        cover = "https://example.com/images/les-miserables.jpg",
        status = "lu",
        addedDate = "2024-08-20"
    ),
    Book(
        id = 5,
        title = "La Nuit des temps",
        author = "René Barjavel",
        genre = "Science-fiction, Romance",
        path = "pomme.pdf",
        cover = "https://example.com/images/la-nuit-des-temps.jpg",
        status = "à lire",
        addedDate = "2024-07-30"
    ),
    Book(
        id = 6,
        title = "Le Meilleur des mondes",
        author = "Aldous Huxley",
        genre = "Science-fiction, Dystopie",
        path = "pomme.pdf",
        cover = "https://example.com/images/le-meilleur-des-mondes.jpg",
        status = "lu",
        addedDate = "2024-06-10"
    ),
    Book(
        id = 7,
        title = "Le Meilleur des mondes",
        author = "Aldous Huxley",
        genre = "Science-fiction, Dystopie",
        path = "pomme.pdf",
        cover = "https://example.com/images/le-meilleur-des-mondes.jpg",
        status = "lu",
        addedDate = "2024-06-10"
    ),
    Book(
        id = 8,
        title = "Le Meilleur des mondes",
        author = "Aldous Huxley",
        genre = "Science-fiction, Dystopie",
        path = "pomme.pdf",
        cover = "https://example.com/images/le-meilleur-des-mondes.jpg",
        status = "lu",
        addedDate = "2024-06-10"
    ),
    Book(
        id = 9,
        title = "Le Meilleur des mondes",
        author = "Aldous Huxley",
        genre = "Science-fiction, Dystopie",
        path = "pomme.pdf",
        cover = "https://example.com/images/le-meilleur-des-mondes.jpg",
        status = "lu",
        addedDate = "2024-06-10"
    ),
    Book(
        id = 10,
        title = "Le Meilleur des mondes",
        author = "Aldous Huxley",
        genre = "Science-fiction, Dystopie",
        path = "pomme.pdf",
        cover = "https://example.com/images/le-meilleur-des-mondes.jpg",
        status = "lu",
        addedDate = "2024-06-10"
    ),
    Book(
        id = 11,
        title = "Le Meilleur des mondes",
        author = "Aldous Huxley",
        genre = "Science-fiction, Dystopie",
        path = "pomme.pdf",
        cover = "https://example.com/images/le-meilleur-des-mondes.jpg",
        status = "lu",
        addedDate = "2024-06-10"
    ),
    Book(
        id = 12,
        title = "Le Meilleur des mondes",
        author = "Aldous Huxley",
        genre = "Science-fiction, Dystopie",
        path = "pomme.pdf",
        cover = "https://example.com/images/le-meilleur-des-mondes.jpg",
        status = "lu",
        addedDate = "2024-06-10"
    )
)


@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun CitationGrid() {
    val exempleBook = Book(
        id = 6,
        title = "Le Meilleur des mondes",
        author = "Aldous Huxley",
        genre = "Science-fiction, Dystopie",
        path = "pomme.pdf",
        cover = "https://example.com/images/le-meilleur-des-mondes.jpg",
        status = "lu",
        addedDate = "2024-06-10"
    )
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(citationData) { citation ->
            Row {
                println(citation)
                CitationCard(citation.text, citation.author, exempleBook ){}
            }
        }
    }
}




