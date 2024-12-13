
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color



@Composable
@Preview
fun SummaryScreen() {

    Row(modifier = Modifier
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFFFFFFF), // Blanc
                                Color(0xFFF5F5F5), // Gris très clair
                                Color(0xFFE3F2FD),  // Vert
                                Color(0xFFE3FFDE)
                            )
                        ))) {
        Row {
           // Text(text = "=== Summary ===")
        }
        BookGrid(bookListe)
    }
}
