
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun Confetti(isok : Boolean) {
    val emojis = listOf( "⬜", "□", "⭐", "\uD83C\uDC06")
    Box(modifier = Modifier.fillMaxSize()) {
        repeat(50) {
            if(isok)
                AnimatedConfetti(emojis[Random.nextInt(emojis.size)])
        }
    }
}

@Composable
fun AnimatedConfetti(emoji: String) {
    var xOffset by remember { mutableStateOf(Random.nextInt(0, 400).dp) }
    var yOffset by remember { mutableStateOf(-50.dp) }

    val yAnimation = rememberInfiniteTransition().animateFloat(
        initialValue = -50f,
        targetValue = 650f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = Random.nextInt(2000, 5000), easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val xAnimation = rememberInfiniteTransition().animateFloat(
        initialValue = xOffset.value,
        targetValue = xOffset.value + Random.nextInt(-100, 100),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = Random.nextInt(1000, 3000), easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val rotation = rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = Random.nextInt(3000, 5000), easing = LinearEasing)
        )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = emoji,
            fontSize = (10 + Random.nextInt(100)).sp,
            modifier = Modifier
                .offset(x = (Random.nextInt(100) + xAnimation.value).dp, y = (Random.nextInt(100) + yAnimation.value).dp)  // Valeurs fixes pour la position
                .rotate(rotation.value),
            color = Color(Random.nextInt(55) + 10, Random.nextInt(155) + 100, (Random.nextInt(155) + 240) % 205 , 95)
        )
    }

}
