package tn.esprit.lastjetpack.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import tn.esprit.lastjetpack.data.models.Events

@Dao
interface EventDao {

    @Insert
    suspend fun insertEvent(event: Events)

    @Delete
    suspend fun deleteEvent(event: Events)

    @Query("SELECT * FROM events")
    suspend fun getAllEvents(): List<Events>

    @Query("SELECT * FROM events WHERE id = :id")
    suspend fun getEventById(id: Int): Events?
}
