
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val genre: String,
    val path: String,
    val cover: String, // correspond à "img" dans ton ancien modèle
    val status: String,
    val addedDate: String
)

@Serializable
data class BooksData(val books: List<Book>)


/*
fun loadBooksFromJson(filePath: String): List<BooksData> {
    val jsonString = File(filePath).readText()
    return listOf(Json.decodeFromString<BooksData>(jsonString)).toList()
}
*/



fun loadBooksFromJson(filePath: String): List<Book>? {
    val jsonString = File(filePath).readText()  // Lit le fichier JSON
    val booksData = Json.decodeFromString<BooksData>(jsonString)  // Décode le JSON en BooksData
    return booksData.books  // Retourne la liste de livres
}

val bookList = listOf(
    Book(
        id = 1,
        title = "Le Petit Prince",
        author = "Antoine de Saint-Exupéry",
        genre = "Philosophique, Aventure",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/le_petit_prince.pdf",
        cover = "https://example.com/images/le-petit-prince.jpg",
        status = "à lire",
        addedDate = "2024-11-01"
    ),
    Book(
        id = 2,
        title = "1984",
        author = "George Orwell",
        genre = "Science-fiction, Dystopie",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/1984.pdf",
        cover = "https://example.com/images/1984.jpg",
        status = "lu",
        addedDate = "2024-10-10"
    ),
    Book(
        id = 3,
        title = "L'Alchimiste",
        author = "Paulo Coelho",
        genre = "Fiction philosophique",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/alchimiste.pdf",
        cover = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/L1.jpg",
        status = "en cours",
        addedDate = "2024-09-15"
    ),
    Book(
        id = 4,
        title = "Les Misérables",
        author = "Victor Hugo",
        genre = "Historique, Drame",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/miserables_les.pdf",
        cover = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/L1.jpg",
        status = "lu",
        addedDate = "2024-08-20"
    ),
    Book(
        id = 5,
        title = "La Nuit des temps juste pour voir si c'est trop grand",
        author = "René Barjavel",
        genre = "Science-fiction, Romance",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/temps.pdf",
        cover = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/L1.jpg",
        status = "à lire",
        addedDate = "2024-07-30"
    ),
    Book(
        id = 6,
        title = "Le Meilleur des mondes",
        author = "Aldous Huxley",
        genre = "Science-fiction, Dystopie",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/monde.pdf",
        cover = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/L1.jpg",
        status = "lu",
        addedDate = "2024-06-10"
    )
)


val bookListe = listOf(
    Book(
        id = 1,
        title = "Le Petit Prince",
        author = "Antoine de Saint-Exupéry",
        genre = "Philosophique, Aventure",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/le_petit_prince.pdf",
        cover = "L1.jpg",
        status = "à lire",
        addedDate = "2024-11-01"
    ),
    Book(
        id = 2,
        title = "1984",
        author = "George Orwell",
        genre = "Science-fiction, Dystopie",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/1984.pdf",
        cover = "L2.jpg",
        status = "lu",
        addedDate = "2024-10-10"
    ),
    Book(
        id = 3,
        title = "L'Alchimiste",
        author = "Paulo Coelho",
        genre = "Fiction philosophique",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/alchimiste.pdf",
        cover = "L3.jpg",
        status = "en cours",
        addedDate = "2024-09-15"
    ),
    Book(
        id = 4,
        title = "Les Misérables",
        author = "Victor Hugo",
        genre = "Historique, Drame",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/miserables_les.pdf",
        cover = "L4.jpg",
        status = "lu",
        addedDate = "2024-08-20"
    ),
    Book(
        id = 5,
        title = "La Nuit des temps juste pour voir si c'est trop grand",
        author = "René Barjavel",
        genre = "Science-fiction, Romance",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/temps.pdf",
        cover = "L5.jpg",
        status = "à lire",
        addedDate = "2024-07-30"
    ),
    Book(
        id = 6,
        title = "Le Meilleur des mondes",
        author = "Aldous Huxley",
        genre = "Science-fiction, Dystopie",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/monde.pdf",
        cover = "L6.jpg",
        status = "lu",
        addedDate = "2024-06-10"
    )
)

val bookListes = listOf(
    Book(
        id = 1,
        title = "Le Petit Prince",
        author = "Antoine de Saint-Exupéry",
        genre = "Philosophique, Aventure",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/le_petit_prince.pdf",
        cover = "https://example.com/images/le-petit-prince.jpg",
        status = "à lire",
        addedDate = "2024-11-01"
    ),
    Book(
        id = 2,
        title = "1984",
        author = "George Orwell",
        genre = "Science-fiction, Dystopie",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/1984.pdf",
        cover = "https://example.com/images/1984.jpg",
        status = "lu",
        addedDate = "2024-10-10"
    ),
    Book(
        id = 3,
        title = "L'Alchimiste",
        author = "Paulo Coelho",
        genre = "Fiction philosophique",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/alchimiste.pdf",
        cover = "https://example.com/images/l-alchimiste.jpg",
        status = "en cours",
        addedDate = "2024-09-15"
    ),
    Book(
        id = 4,
        title = "Les Misérables",
        author = "Victor Hugo",
        genre = "Historique, Drame",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/miserables_les.pdf",
        cover = "https://example.com/images/les-miserables.jpg",
        status = "lu",
        addedDate = "2024-08-20"
    ),
    Book(
        id = 5,
        title = "La Nuit des temps juste pour voir si c'est trop grand",
        author = "René Barjavel",
        genre = "Science-fiction, Romance",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/temps.pdf",
        cover = "https://example.com/images/la-nuit-des-temps.jpg",
        status = "à lire",
        addedDate = "2024-07-30"
    ),
    Book(
        id = 6,
        title = "Le Meilleur des mondes",
        author = "Aldous Huxley",
        genre = "Science-fiction, Dystopie",
        path = "/home/etudiants/master1/houssam.bacar/Documents/KOTLIN_SINGLEPLATEFORME/projet/Lisartsphere/src/jvmMain/resources/monde.pdf",
        cover = "https://example.com/images/le-meilleur-des-mondes.jpg",
        status = "lu",
        addedDate = "2024-06-10"
    )
)