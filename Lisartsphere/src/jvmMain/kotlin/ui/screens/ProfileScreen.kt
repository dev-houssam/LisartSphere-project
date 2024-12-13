
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ProfileScreen() {
    val userName = "Houssam Bacar"
    val booksRead = 45
    val booksUnread = 10
    val clubs = 5
    val summaries = 12
    val country = "France"
    val challengesWon = 3

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.surface)
                    .padding(5.dp).background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFFFFFF), // Blanc
                            Color(0xFFF5F5F5), // Gris très clair
                            Color(0xFFE3F2FD)  // Vert
                        )
                    )),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Picture
        Box(
                modifier = Modifier
                        .size(120.dp)
                        .background(MaterialTheme.colors.primary, CircleShape),
                contentAlignment = Alignment.Center
        ) {
            Image(
                    painter = painterResource("image_user.png"),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                            .size(110.dp)
                            .background(Color.White, CircleShape)
                            .padding(4.dp),
                    contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Name
        Text(
                text = userName,
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colors.primary
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Stats
        Card(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = 4.dp
        ) {
            Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.Start
            ) {
                ProfileStat("Books Read", booksRead)
                ProfileStat("Books Unread", booksUnread)
                ProfileStat("Clubs Joined", clubs)

                ProfileStat("Country", country)
                ProfileStat("Challenges Won", challengesWon)
            }
        }
    }
}

@Composable
fun ProfileStat(label: String, value: Any) {
    Row(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
                text = label,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
        )
        Text(
                text = value.toString(),
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colors.primary
        )
    }
}
