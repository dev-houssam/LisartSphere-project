package models

import Book
import kotlinx.serialization.Serializable

@Serializable
data class ClubLecture(
    val id: String, // Identifiant unique
    val nom: String, // Nom du club
    val description: String, // Description ou mission du club
    val membre: List<User>, // Liste des membres inscrits
    val books: List<Book>, // Liste des livres lus ou en cours par le club
    val meetingSchedule: String, // Horaires ou fréquence des réunions (ex : "Tous les samedis à 15h")
    val createdAt: String, // Date de création
    val updatedAt: String, // Dernière mise à jour
    val creator: User // Utilisateur qui a créé le club
)

