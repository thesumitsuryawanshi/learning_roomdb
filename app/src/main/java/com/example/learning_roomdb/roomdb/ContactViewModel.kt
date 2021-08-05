package com.example.learning_roomdb.roomdb

import android.app.Application
import android.util.Log.d
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    val allContact: LiveData<List<Contact>>
    val repository: ContactRepository

    init {
        val dao = ContactDatabase.getDatabase(application).getcontactdoa()
        repository = ContactRepository(dao)
        allContact = repository.contactListData
    }

    fun deleteContact(contact: Contact) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(contact)
    }

    fun addContact(contact: Contact) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(contact)
    }

    fun updateContact( contact: Contact) = viewModelScope.launch(Dispatchers.IO) {
        repository.update( contact)
        d(" viewmodel", "we are in the viewmodel where  name : $contact  ")

    }

}

