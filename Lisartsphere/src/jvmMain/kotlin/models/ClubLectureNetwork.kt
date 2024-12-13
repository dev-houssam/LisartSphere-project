package models

data class ReadingClubNetwork(
    val clubs: List<ClubLecture>, // Liste des clubs de lecture
    val totalClubs: Int, // Nombre total de clubs
    val totalMembers: Int, // Nombre total de membres à travers tous les clubs
    val mostActiveClub: ClubLecture? // Club ayant le plus d'activités ou de membres
)


/*

val user1 = User("1", "Houssam", "Bacar", "houssam@example.com", "Mahoraise", "France", "2024-01-01")
val user2 = User("2", "Sarah", "Doe", "sarah@example.com", "Anglaise", "France", "2023-12-01")
val user3 = User("3", "John", "Smith", "john@example.com", "Américaine", "USA", "2022-06-15")

val book1 = Book("Le Petit Prince", "Antoine de Saint-Exupéry", "Fiction", "Lu", "path_to_image1.jpg")
val book2 = Book("1984", "George Orwell", "Science-Fiction", "Lu", "path_to_image2.jpg")
val book3 = Book("L'Alchimiste", "Paulo Coelho", "Philosophie", "En cours", "path_to_image3.jpg")

val club1 = ClubLecture(
    id = "1",
    nom = "Philosophes Littéraires",
    description = "Un club pour discuter des œuvres philosophiques et littéraires.",
    membre = listOf(user1, user2),
    books = listOf(book1, book2),
    meetingSchedule = "Tous les vendredis à 18h",
    createdAt = "2023-10-01",
    updatedAt = "2024-01-01",
    creator = user1
)

val club2 = ClubLecture(
    id = "2",
    nom = "Science et Fiction",
    description = "Pour les passionnés de science-fiction et d'univers alternatifs.",
    membre = listOf(user2, user3),
    books = listOf(book2, book3),
    meetingSchedule = "Deuxième samedi du mois à 14h",
    createdAt = "2022-08-15",
    updatedAt = "2024-01-02",
    creator = user3
)

val readingClubNetwork = ReadingClubNetwork(
    clubs = listOf(club1, club2),
    totalClubs = 2,
    totalMembers = club1.membre.size + club2.membre.size,
    mostActiveClub = club1 // Suppose que club1 est le plus actif
)
*/
