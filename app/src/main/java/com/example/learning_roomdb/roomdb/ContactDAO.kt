package com.example.learning_roomdb.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContactDAO {

    @Query("SELECT * FROM contact ORDER BY id ASC")
    fun getAlphabetizedWords(): List<Contact>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(contact: Contact)

    @Query("DELETE FROM contact ")
    suspend fun deleteAll()

}
