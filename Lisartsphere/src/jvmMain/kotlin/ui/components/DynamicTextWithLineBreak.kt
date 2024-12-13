package ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalTextApi::class)
@Composable
fun DynamicText(title: String, maxWidth: Int, textStyle: TextStyle) {
    Text(
        text = title,
        style = textStyle,
        maxLines = Int.MAX_VALUE,
        modifier = Modifier.widthIn(max = maxWidth.dp).padding(4.dp)
    )
}

