package tn.esprit.lastjetpack.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import tn.esprit.lastjetpack.data.models.Events
import tn.esprit.lastjetpack.ui.screens.EventItem


@Composable
fun EventsScreen(eventsList: List<Events>, onEventClick: (Events) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(eventsList) { event ->
            EventItem(event, onEventClick)
        }
    }
}

//@Composable
//fun EventItem(event: Events, onEventClick: (Events) -> Unit) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//    ) {
//        Image(
//            painter = rememberAsyncImagePainter(model = event.imageRes),
//            contentDescription = event.title,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(180.dp)
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(
//            text = event.title,
//            style = MaterialTheme.typography.bodyLarge,
//            color = Color.Black
//        )
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(
//            text = event.description,
//            style = MaterialTheme.typography.bodyMedium,
//            textAlign = TextAlign.Justify
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Button(onClick = { onEventClick(event) }) {
//            Text("Bookmark Event")
//        }
//    }
//}
