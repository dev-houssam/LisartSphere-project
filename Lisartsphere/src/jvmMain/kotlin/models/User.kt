package models

data class User(
    val id: Int,
    val title: String,
    val author: String,
    val genre: String,
    val cover: String, // correspond à "img" dans ton ancien modèle
    val status: String,
    val addedDate: String
)