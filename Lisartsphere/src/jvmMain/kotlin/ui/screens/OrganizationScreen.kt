package ui.screens


import Book
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import bookList


@Composable
@Preview
fun OrganizationScreen() {
    var books = remember { mutableStateListOf(*bookList.toTypedArray()) } // Liste mutable pour permettre le réarrangement

    Column(modifier = Modifier.padding(16.dp)) {
        //Text(text = "=== Organisation ===", style = MaterialTheme.typography.h6)

        // Grille avec LazyVerticalGrid pour organiser les cartes en plusieurs colonnes
        LazyVerticalGrid(
            columns = GridCells.Fixed(1), // Trois colonnes
            modifier = Modifier.fillMaxSize()
        ) {
            items(books) { book ->
                val currentIndex = books.indexOf(book)
                BookCardWithButtons(book = book, currentIndex = currentIndex, bookList = books)

            }
        }
    }
}

@Composable
fun BookCardWithButtons(book: Book, currentIndex: Int, bookList: MutableList<Book>) {
    Card(
        modifier = Modifier
            .width(100.dp).size(200.dp)
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Affichage du titre du livre
            Text(text = book.title, style = MaterialTheme.typography.body1)


            // Boutons pour déplacer les livres dans la grille
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xFFFFFFFF), // Blanc
                                        Color(0xFFF5F5F5),
                                        Color(0xFFFFFFFF),// Gris très clair
                                        Color(0xFFE3F2FD), // Vert
                                        Color(0x00F000F0),  // Orange
                                        Color(0xFFFFFFFF),
                                    ),
                                    // Définir le point de fin du dégradé
                                )
                            )
                            .graphicsLayer {
                                shadowElevation = 400.dp.toPx() // Ajouter un léger effet de flou
                                shape = RoundedCornerShape(0.dp) // Arrondir les coins si nécessaire
                                clip = true
                            }
                    )
                    Button(onClick = { moveBookUp(currentIndex, bookList) }) {
                        Text("↑")
                    }

                    Button(onClick = { moveBookDown(currentIndex, bookList) }) {
                        Text("↓")
                    }
                }
            }

        }
    }
}
fun moveBookUp(index: Int, bookList: MutableList<Book>) {
    if (index > 0) {
        val temp = bookList[index]
        bookList[index] = bookList[index - 1]
        bookList[index - 1] = temp
    }
}

fun moveBookDown(index: Int, bookList: MutableList<Book>) {
    if (index < bookList.size - 1) {
        val temp = bookList[index]
        bookList[index] = bookList[index + 1]
        bookList[index + 1] = temp
    }
}




@Composable
@Preview
fun OrganizationScreenPreview() {
    OrganizationScreen()
}
