package models

import Book
import kotlinx.serialization.Serializable

@Serializable
data class Resume(
    val id: String, // Identifiant unique du résumé
    val title: String, // Titre du résumé
    val content: String, // Contenu détaillé du résumé
    val book: Book?, // Livre associé (si applicable)
    val author: User, // Utilisateur qui a écrit le résumé
    val createdAt: String, // Date de création
    val updatedAt: String?, // Dernière mise à jour (peut être null si jamais modifié)
    val status: String // Statut : "Public", "Privé", ou autre
)

