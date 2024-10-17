package tn.esprit.jetpack_nascar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
    val eventTitles = listOf(
        stringResource(R.string.event1),
        stringResource(R.string.event2),
        stringResource(R.string.event3),
        stringResource(R.string.event4)
    )

    val eventDates = listOf(
        stringResource(R.string.eventDate1),
        stringResource(R.string.eventDate2),
        stringResource(R.string.eventDate3),
        stringResource(R.string.eventDate4)
    )

    val eventImages = listOf(
        R.drawable.ic_event1,
        R.drawable.ic_event2,
        R.drawable.ic_event3,
        R.drawable.ic_event4
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(eventTitles.size) { index ->
            EventCard(
                imageRes = eventImages[index],
                title = eventTitles[index],
                date = eventDates[index]
            )
        }
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
