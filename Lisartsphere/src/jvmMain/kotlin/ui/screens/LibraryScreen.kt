package ui.screens
import BookGrid
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import bookListe


@Composable
@Preview
fun LibraryScreen() {
    BookGrid(bookListe)
}
