package com.example.learning_roomdb.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun getcontactdoa(): ContactDAO

//its a juction where all things gets connected
// passing entities means connecting tables to databases i.e passing entities to array.
//version should be updated when our app is updated (2.0)


    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}