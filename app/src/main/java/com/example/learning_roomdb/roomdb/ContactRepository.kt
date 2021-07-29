package com.example.learning_roomdb.roomdb

import androidx.lifecycle.LiveData

class ContactRepository(private val ContactDAO: ContactDAO) {

    val contactListData : LiveData<List<Contact>> = ContactDAO.getAllData()

    suspend fun insert(contact: Contact) {
        ContactDAO.insert(contact)
    }

    suspend fun delete(contact: Contact) {
        ContactDAO.delete(contact)
    }

}
