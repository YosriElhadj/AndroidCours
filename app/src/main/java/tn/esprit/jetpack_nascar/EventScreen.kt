package tn.esprit.jetpack_nascar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EventsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
    ) {
        EventCard(
            imageRes = R.drawable.ic_event1,
            title = stringResource(id = R.string.event1),
            date = stringResource(id = R.string.eventDate1)
        )
        EventCard(
            imageRes = R.drawable.ic_event2,
            title = stringResource(id = R.string.event2),
            date = stringResource(id = R.string.eventDate2)
        )
        EventCard(
            imageRes = R.drawable.ic_event3,
            title = stringResource(id = R.string.event3),
            date = stringResource(id = R.string.eventDate3)
        )
        EventCard(
            imageRes = R.drawable.ic_event4,
            title = stringResource(id = R.string.event4),
            date = stringResource(id = R.string.eventDate4)
        )
    }
}

@Composable
fun EventCard(imageRes: Int, title: String, date: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .size(100.dp),
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = date,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Red
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEventScreen() {
    EventsScreen()
}
