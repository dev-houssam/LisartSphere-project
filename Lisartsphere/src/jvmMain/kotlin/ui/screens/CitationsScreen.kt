package ui.screens

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import ui.components.CitationGrid

@Composable
@Preview
fun CitationsScreen() {

   Row {
      Column {

         CitationGrid()

      }
   }

}
