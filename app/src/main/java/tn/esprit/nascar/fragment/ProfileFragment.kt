package tn.esprit.nascar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tn.esprit.nascar.adapters.BookmarksAdapter
import tn.esprit.nascar.databinding.FragmentProfileBinding
import tn.esprit.nascar.utils.AppDatabase

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        // Set up RecyclerView with a vertical LinearLayoutManager
        binding.rvBookmarks.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        // Fetch all bookmarked events from the database and set the adapter
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            val eventDao = AppDatabase.getDatabase(requireContext()).eventDao()
            val bookmarkedEvents = eventDao.getAllEvent() // Fetch all events from database (or only bookmarked events if filtered)

            withContext(Dispatchers.Main) {
                // Create the BookmarksAdapter, passing eventDao, and assign it to the RecyclerView
                val bookmarksAdapter = BookmarksAdapter(bookmarkedEvents, eventDao)
                binding.rvBookmarks.adapter = bookmarksAdapter
            }
        }

        return binding.root
    }
}
