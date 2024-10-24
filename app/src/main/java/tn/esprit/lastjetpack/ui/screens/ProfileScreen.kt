package tn.esprit.lastjetpack.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tn.esprit.lastjetpack.data.models.Events

@Composable
fun ProfileScreen(
    eventsList: List<Events>,
    onRemoveBookmarkClick: (Events) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(eventsList) { event ->
            BookmarkItem(event, onRemoveBookmarkClick)
        }
    }
}

@Composable
fun BookmarkItem(
    event: Events,
    onRemoveBookmarkClick: (Events) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = event.title)
        Spacer(modifier = Modifier.height(4.dp))
        Button(onClick = { onRemoveBookmarkClick(event) }) {
            Text("Remove Bookmark")
        }
    }
}
