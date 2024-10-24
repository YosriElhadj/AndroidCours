package tn.esprit.nascar.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import tn.esprit.nascar.models.Events


//TODO 9 Change this interface to a DAO and add 4 methods with the proper annotation:

// insertEvent(events: Events)
// deleteEvent(events: Events)
// getAllEvent() : MutableList<Events>
// getFindEventById(id: Int) : Events
@Dao
public interface EventDao {
    @Insert
    fun insertEvent(events: Events)
    @Delete
    fun deleteEvent(events: Events)
    @Query("SELECT * FROM Events")
    fun getAllEvent() : MutableList<Events>
    @Query("SELECT * FROM Events WHERE id = :id")
    fun getFindEventById(id: Int) : Events





}