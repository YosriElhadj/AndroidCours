package tn.esprit.lastjetpack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import tn.esprit.lastjetpack.data.AppDatabase
import tn.esprit.lastjetpack.data.models.Events
import tn.esprit.lastjetpack.ui.screens.MainScreen
import tn.esprit.lastjetpack.ui.screens.ProfileScreen
import tn.esprit.lastjetpack.ui.theme.LastJetpackTheme

class MainActivity : ComponentActivity() {

    private lateinit var database: AppDatabase
    private var eventsList = mutableListOf<Events>()

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the Room database
        database = AppDatabase.getDatabase(this)

        // Fetch the list of events from the database
        lifecycleScope.launch {
            eventsList = database.eventDao().getAllEvents().toMutableList()
        }

        setContent {
            LastJetpackTheme {
                var currentEvents by remember { mutableStateOf(eventsList) }

                // MainScreen handles event insertion/bookmarking
                MainScreen(
                    newsList = listOf(),  // Replace with your actual data or empty list
                    eventsList = currentEvents,
                    onEventClick = { event ->
                        // Insert (bookmark) event
                        lifecycleScope.launch {
                            database.eventDao().insertEvent(event)
                            // Refresh the list after insertion
                            currentEvents = database.eventDao().getAllEvents().toMutableList()
                        }
                    }
                )

                // ProfileScreen handles event removal/unbookmarking
                ProfileScreen(
                    eventsList = currentEvents,
                    onRemoveBookmarkClick = { event ->
                        // Remove (delete) event
                        lifecycleScope.launch {
                            database.eventDao().deleteEvent(event)
                            // Refresh the list after deletion
                            currentEvents = database.eventDao().getAllEvents().toMutableList()
                        }
                    }
                )
            }
        }
    }
}
