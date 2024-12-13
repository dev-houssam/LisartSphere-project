
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.BookCard
import java.io.File


// Liste de livres pour l'exemple

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BookGrid(bookList: List<Book>) {
    var selectedBook by remember { mutableStateOf<Book?>(null) }

    if (selectedBook == null) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 180.dp), // Ajuste dynamiquement les colonnes
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(bookList) { book ->
                BookCard(
                    book = book,
                    onBookClick = { clickedBook ->
                        selectedBook = clickedBook
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(80f) // Contrôle la taille des cartes
                )
            }
        }
    } else {
        // Afficher le lecteur PDF pour le livre sélectionné
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = { selectedBook = null }) {
                Text("Retour à la liste des livres")
            }
            //PdfReader(file = File(selectedBook?.path ?: ""))
            PdfReaderDoubleView(file = File(selectedBook?.path ?: ""))
        }
    }
}