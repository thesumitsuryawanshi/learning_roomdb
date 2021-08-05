package com.example.learning_roomdb.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {

    @Query("SELECT * FROM contactTable ORDER BY id ASC")
    fun getAllData(): LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)

    @Update
    suspend fun update(contact: Contact)


}
