package ui.components


import Book
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BookCard(book: Book, onBookClick: (Book) -> Unit, modifier: Modifier) {
    Card(
        onClick = { onBookClick(book) }, // Appeler la fonction de clic avec le livre sélectionné
        modifier = Modifier.width(280.dp).height(380.dp)
    ) {
        Column(modifier = Modifier.width(100.dp).padding(16.dp)) {
            Image(
                painter = painterResource(book.cover),
                contentDescription = book.title,
                modifier = Modifier. size(150.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(start = 15.dp)) {
                DynamicText(book.title, 250, MaterialTheme.typography.h6)
                Text(book.author, style = MaterialTheme.typography.body2)
            }
        }
    }
}