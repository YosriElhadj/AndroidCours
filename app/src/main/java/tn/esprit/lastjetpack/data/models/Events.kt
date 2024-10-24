package tn.esprit.lastjetpack.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Events(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val imageRes: Int,   // Resource ID for event images
    val title: String,
    val description: String
)
