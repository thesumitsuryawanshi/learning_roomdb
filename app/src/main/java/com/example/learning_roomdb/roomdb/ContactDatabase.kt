package com.example.learning_roomdb.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1)

abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactdoa(): ContactDAO


//its a juction where all things gets connected
// passing entities means connecting tables to databases i.e passing entities to array.
//version should be updated when our app is updated (2.0)


}