import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tn.esprit.nascar.dao.EventDao
import tn.esprit.nascar.databinding.SingleItemEventsBinding
import tn.esprit.nascar.models.Events
import tn.esprit.nascar.utils.AppDatabase

class EventsAdapter(
    private val eventsList: MutableList<Events>,
    private val eventDao: EventDao // Pass EventDao through the constructor
) : RecyclerView.Adapter<EventsAdapter.EventsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsHolder {
        val binding = SingleItemEventsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventsHolder(binding)
    }

    override fun onBindViewHolder(holder: EventsHolder, position: Int) {
        with(holder) {
            with(eventsList[position]) {
                binding.eventTitle.text = title
                binding.eventDescription.text = description
                binding.eventImage.setImageResource(imageRes)
                binding.btnAddBookmark.setOnClickListener {
                    // Check if this event is already in the database
                    GlobalScope.launch(Dispatchers.IO) {
                        val existingEvent = eventDao.getFindEventById(id) // Use eventDao

                        withContext(Dispatchers.Main) {
                            if (existingEvent != null) {
                                // Event already exists, show Snackbar
                                Snackbar.make(binding.root, "Event already bookmarked!", Snackbar.LENGTH_SHORT).show()
                            } else {
                                // Event does not exist, add to the database
                                val newEvent = Events(id, imageRes, title, description)
                                GlobalScope.launch(Dispatchers.IO) {
                                    eventDao.insertEvent(newEvent) // Use eventDao
                                    withContext(Dispatchers.Main) {
                                        // Show Snackbar after adding event
                                        Snackbar.make(binding.root, "Event added to bookmarks!", Snackbar.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getItemCount() = eventsList.size

    inner class EventsHolder(val binding: SingleItemEventsBinding) : RecyclerView.ViewHolder(binding.root)
}
