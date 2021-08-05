package com.example.learning_roomdb

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learning_roomdb.adapter.ContactRVAdapter
import com.example.learning_roomdb.adapter.IContactRVAdapter
import com.example.learning_roomdb.roomdb.Contact
import com.example.learning_roomdb.roomdb.ContactViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IContactRVAdapter {


    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ContactRVAdapter(this, this)
        contactRecyclerView.adapter = adapter

        viewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            ).get(ContactViewModel::class.java)

        viewModel.allContact.observe(this, Observer { List ->
            List?.let {
                adapter.updateList(it)
            }
        })


    }

    override fun onDeleteClicked(contact: Contact) {
        viewModel.deleteContact(contact)
        Toast.makeText(this, "${contact.name} is deleted", Toast.LENGTH_SHORT).show()
    }

    override fun onEditClicked(contact: Contact) {
        inputContact.setText(contact.name)
        inputContact.setTag(inputContact.id, contact.column_Id)
        btnadddata.setText("Update")
    }

    fun addData(view: View) {
        val ipContact = inputContact.text.toString()

        if (ipContact.isNotEmpty() && btnadddata.text.equals("Add")) {
            val newContact = Contact(0, ipContact)
            viewModel.addContact(newContact)
            Toast.makeText(this, "${newContact.name} is Inserted ", Toast.LENGTH_SHORT).show()
        } else {
            val temp = inputContact.id
            Log.d("updateBtn", "this is the execution of else block and $temp ")

            val updatedContact =
                Contact(inputContact.getTag(inputContact.id).toString().toInt(), ipContact)

            viewModel.updateContact(updatedContact)
            Toast.makeText(
                this,
                "data Updated : \n id : ${updatedContact.column_Id}  text : ${updatedContact.name}",
                Toast.LENGTH_SHORT
            ).show()
            btnadddata.setText("Add")
        }
        inputContact.setText("")
    }
}





