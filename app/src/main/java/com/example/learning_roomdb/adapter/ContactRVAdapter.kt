package com.example.learning_roomdb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learning_roomdb.R
import com.example.learning_roomdb.roomdb.Contact
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactRVAdapter(private val context: Context, private val listener: IContactRVAdapter) :
    RecyclerView.Adapter<ContactRVAdapter.ViewHolder>() {

    private val allContact = ArrayList<Contact>()

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val btndelete: ImageView = itemview.imageView
        val textView: TextView = itemView.textView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false))

        view.btndelete.setOnClickListener { listener.onContactClicked(allContact[view.adapterPosition]) }
        return view
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentContact = allContact[position]
        holder.textView.text = currentContact.name
    }

    override fun getItemCount(): Int {
        return allContact.size
    }

    fun updateList(newList: List<Contact>) {
        allContact.clear()
        allContact.addAll(newList)
        notifyDataSetChanged()
    }

}

interface IContactRVAdapter {
    fun onContactClicked(contact: Contact)
}
