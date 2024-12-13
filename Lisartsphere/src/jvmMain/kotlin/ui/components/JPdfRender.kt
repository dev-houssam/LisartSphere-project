
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.rendering.PDFRenderer
import java.awt.image.BufferedImage
import java.io.File

@Composable
fun PdfReaderWithOutZoom(file: File) {
    var currentPage by remember { mutableStateOf(0) }
    var pageCount by remember { mutableStateOf(0) }
    val bitmap = remember { mutableStateOf<BufferedImage?>(null) }

    // Charger le PDF et rendre la page actuelle
    LaunchedEffect(file, currentPage) {
        val document = PDDocument.load(file)
        val renderer = PDFRenderer(document)
        pageCount = document.numberOfPages
        bitmap.value = renderer.renderImage(currentPage, 2.0f) // Zoom 2x pour meilleure qualité
        document.close()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Affichage de la page PDF
        bitmap.value?.let { image ->
            Image(
                painter = BitmapPainter(image.toComposeImageBitmap()),
                contentDescription = "Page ${currentPage + 1}",
                modifier = Modifier.weight(1f).fillMaxWidth()
            )
        }

        // Boutons de navigation
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { if (currentPage > 0) currentPage-- },
                enabled = currentPage > 0 // Désactiver si première page
            ) {
                Text("Précédent")
            }

            Text(text = "Page ${currentPage + 1} sur $pageCount", modifier = Modifier.padding(16.dp))

            Button(
                onClick = { if (currentPage < pageCount - 1) currentPage++ },
                enabled = currentPage < pageCount - 1 // Désactiver si dernière page
            ) {
                Text("Suivant")
            }
        }
    }
}

@Composable
fun PdfReader(file: File) {
    var currentPage by remember { mutableStateOf(0) }
    var pageCount by remember { mutableStateOf(0) }
    val bitmap = remember { mutableStateOf<BufferedImage?>(null) }
    var zoomLevel by remember { mutableStateOf(1.0f) } // Niveau de zoom initial

    // Scroll states pour gérer le défilement horizontal et vertical
    val horizontalScrollState = rememberScrollState()
    val verticalScrollState = rememberScrollState()

    // Charger le PDF et rendre la page actuelle avec une qualité dépendante du zoom
    LaunchedEffect(file, currentPage, zoomLevel) {
        val document = PDDocument.load(file)
        val renderer = PDFRenderer(document)
        pageCount = document.numberOfPages

        // Adapter la qualité (DPI) en fonction du zoom
        val dpi = (72 * zoomLevel).toInt()
        bitmap.value = renderer.renderImageWithDPI(currentPage, dpi.toFloat())

        document.close()
    }

    // Conteneur principal
    Box(modifier = Modifier.fillMaxSize()) {
        // Slider pour ajuster le zoom, toujours visible au-dessus
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .zIndex(1f) // Priorité sur la profondeur
                .background(Color.White.copy(alpha = 0.8f)) // Fond semi-transparent pour lisibilité
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Zoom: ${(zoomLevel * 100).toInt()}%", modifier = Modifier.padding(end = 8.dp))
            Slider(
                value = zoomLevel,
                onValueChange = { zoomLevel = it },
                valueRange = 1.0f..4.0f, // Zoom de 1x à 4x
                modifier = Modifier.width(200.dp)
            )
        }

        // Zone de défilement pour l'image PDF
        bitmap.value?.let { image ->
            val imageWidth = (image.width * zoomLevel).toInt()
            val imageHeight = (image.height * zoomLevel).toInt()

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 60.dp, bottom = 60.dp) // Laisser de l'espace pour le slider et les boutons
                    .verticalScroll(verticalScrollState)
                    .horizontalScroll(horizontalScrollState)
            ) {
                Image(
                    painter = BitmapPainter(image.toComposeImageBitmap()),
                    contentDescription = "Page ${currentPage + 1}",
                    modifier = Modifier
                        .width(imageWidth.dp)
                        .height(imageHeight.dp)
                )
            }
        }

        // Boutons de navigation
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { if (currentPage > 0) currentPage-- },
                enabled = currentPage > 0 // Désactiver si première page
            ) {
                Text("Précédent")
            }

            Text(
                text = "Page ${currentPage + 1} sur $pageCount",
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Button(
                onClick = { if (currentPage < pageCount - 1) currentPage++ },
                enabled = currentPage < pageCount - 1 // Désactiver si dernière page
            ) {
                Text("Suivant")
            }
        }
    }
}



@Preview
@Composable
fun PreviewOnePagePdfReader(chemin : String) {
    val pdfFile = File(chemin)
    PdfReader(file = pdfFile)
}



@Composable
fun PdfReaderDoubleView(file: File) {
    var currentPage by remember { mutableStateOf(0) }
    var pageCount by remember { mutableStateOf(0) }
    val bitmaps = remember { mutableStateListOf<BufferedImage?>(null, null) }

    // Charger le PDF et rendre les pages actuelles
    LaunchedEffect(file, currentPage) {
        val document = PDDocument.load(file)
        val renderer = PDFRenderer(document)
        pageCount = document.numberOfPages

        // Charger deux pages en même temps (ou une seule si à la fin du document)
        bitmaps[0] = renderer.renderImage(currentPage, 2.0f)
        bitmaps[1] = if (currentPage + 1 < pageCount) {
            renderer.renderImage(currentPage + 1, 2.0f)
        } else null

        document.close()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Affichage des pages actuelles
            bitmaps[0]?.let { image ->
                Image(
                    painter = BitmapPainter(image.toComposeImageBitmap()),
                    contentDescription = "Page ${currentPage + 1}",
                    modifier = Modifier.weight(1f)
                )
            }
            bitmaps[1]?.let { image ->
                Image(
                    painter = BitmapPainter(image.toComposeImageBitmap()),
                    contentDescription = "Page ${currentPage + 2}",
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Boutons de navigation
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { if (currentPage > 0) currentPage -= 2 },
                enabled = currentPage > 0 // Désactiver si première page
            ) {
                Text("Précédent")
            }

            Text(
                text = "Pages ${currentPage + 1} - ${minOf(currentPage + 2, pageCount)} sur $pageCount",
                modifier = Modifier.padding(16.dp)
            )

            Button(
                onClick = { if (currentPage + 2 < pageCount) currentPage += 2 },
                enabled = currentPage + 2 < pageCount // Désactiver si dernière page
            ) {
                Text("Suivant")
            }
        }
    }
}

@Preview
@Composable
fun PreviewPdfReaderDoubleView(chemin: String) {
    val pdfFile = File(chemin)
    PdfReaderDoubleView(file = pdfFile)
}
