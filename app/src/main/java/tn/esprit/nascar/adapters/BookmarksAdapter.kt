package tn.esprit.nascar.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tn.esprit.nascar.dao.EventDao
import tn.esprit.nascar.databinding.SingleItemBookmarkBinding
import tn.esprit.nascar.models.Events

class BookmarksAdapter(
    private val eventsList: MutableList<Events>,
    private val eventDao: EventDao // Pass EventDao through constructor to handle DB operations
) : RecyclerView.Adapter<BookmarksAdapter.BookmarksHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarksHolder {
        val binding = SingleItemBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookmarksHolder(binding)
    }

    override fun onBindViewHolder(holder: BookmarksHolder, position: Int) {
        with(holder) {
            with(eventsList[position]) {
                binding.eventTitle.text = title
                binding.eventDescription.text = description
                binding.eventImage.setImageResource(imageRes)

                binding.btnRemoveBookmark.setOnClickListener {
                    // Delete the event from the database
                    GlobalScope.launch(Dispatchers.IO) {
                        eventDao.deleteEvent(eventsList[position])

                        // Remove the event from the list and notify adapter on the main thread
                        launch(Dispatchers.Main) {
                            eventsList.removeAt(position)
                            notifyItemRemoved(position)
                        }
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = eventsList.size

    inner class BookmarksHolder(val binding: SingleItemBookmarkBinding) : RecyclerView.ViewHolder(binding.root)
}
