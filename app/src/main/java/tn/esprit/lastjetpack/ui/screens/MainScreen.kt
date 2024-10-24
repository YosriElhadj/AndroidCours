package tn.esprit.lastjetpack.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import tn.esprit.lastjetpack.data.models.Events
import tn.esprit.lastjetpack.data.models.News

@Composable
fun MainScreen(
    newsList: List<News>,
    eventsList: List<Events>,
    onEventClick: (Events) -> Unit
) {
    LazyColumn {
        items(eventsList) { event ->
            EventItem(event, onEventClick)
        }
    }
}

@Composable
fun EventItem(
    event: Events,
    onEventClick: (Events) -> Unit
) {
    // Display the event and trigger the insert when clicked
    Button(onClick = { onEventClick(event) }) {
        Text("Bookmark Event")
    }
}
