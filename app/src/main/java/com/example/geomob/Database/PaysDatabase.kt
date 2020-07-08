package com.example.geomob.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.geomob.DataClasses.*

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [Pays::class,
                    Personalite::class,
                    Ressource::class,
                    Evenement::class,
                    PaysPhoto::class,
                    PaysVideo::class,
                    PersonalitePhoto::class,
                    Tweet::class], version = 1, exportSchema = false)

abstract class PaysDatabase : RoomDatabase() {

    abstract fun paysDao(): PaysDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PaysDatabase? = null

        fun getDatabase(context: Context): PaysDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PaysDatabase::class.java,
                    "Database2.1"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}