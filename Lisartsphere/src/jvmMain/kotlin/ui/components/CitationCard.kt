package ui.components


/******************************/


import Book
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun CitationCard(
    citation: String,
    author: String,
    sourceBook: Book? = null, // Optionnel : null si ce n'est pas lié à un livre
    onReadBookClick: (() -> Unit)? = null // Bouton de redirection vers le mode lecture
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color(0xFFFDF6E3),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Citation principale
            Text(
                text = "\"$citation\"",
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.Bold,
                    lineHeight = 30.sp
                ),
                color = Color(0xFF6B4226),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Auteur de la citation
            Text(
                text = "- $author",
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = Color(0xFFB28C69),
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            // Bouton vers le livre si fourni
            sourceBook?.let { book ->
                Button(
                    onClick = { onReadBookClick?.invoke() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary
                    ),
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 8.dp)
                ) {
                    Text(
                        text = "Lire ${book.title}",
                        color = Color.White
                    )
                }
            }
        }
    }
}




