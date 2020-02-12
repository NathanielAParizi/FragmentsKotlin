package com.example.fragmentskotlin

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_row_items.view.*




class ContactAdapter(val contactList: ArrayList<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_row_items, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return contactList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.populateItem(contactList[position])

    }

    fun addPersonToList(person: Contact) {
        contactList.add(person)
        notifyDataSetChanged()
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateItem(contact: Contact) {
            itemView.txtName.text = contact.name
            itemView.txtPhoneNumber.text = contact.phoneNumber
            itemView.setOnClickListener {

                Log.v("TAG",contact.name)




            }
        }
    }
}
