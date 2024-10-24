package tn.esprit.nascar.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tn.esprit.nascar.dao.EventDao
import tn.esprit.nascar.models.Events

// Change AppDatabase class to an abstract class that inherits from RoomDatabase
@Database(entities = [Events::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDao

    companion object {
        // Singleton instance
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Function to get the database instance
        fun getDatabase(context: Context): AppDatabase {
            // If the instance is null, initialize it
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "nascar_database"
                ).build()
                INSTANCE = instance
                // Return the new instance
                instance
            }
        }
    }
}
