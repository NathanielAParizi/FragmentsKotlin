package com.example.fragmentskotlin

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_recycler_view.*

class MainActivity : AppCompatActivity(), DetailsFragment.OnFragmentInteractionListener,
    RecyclerViewFragment.OnFragmentInteractionListener {


    val recyclerViewFragment by lazy { RecyclerViewFragment() }
    val contactList by lazy { populateContactList() }

    lateinit var blueValue: String



    val adapter by lazy { ContactAdapter(contactList) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    override fun onFragmentInteraction(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
        blueValue = string
        displayAllValues()
    }



    private fun initRecyclerView() {

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvContactList.layoutManager = layoutManager
        rvContactList.adapter = adapter
    }

    fun displayAllValues() {
        if(this::blueValue.isInitialized ) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.recyclerViewFragment,detailsFragment)
                .addToBackStack("GREEN_FRAG")
                .commit()
        }
    }

    private fun populateContactList(): ArrayList<Contact> {

        val returnList = ArrayList<Contact>()
        returnList.add(Contact("Nathan", "8034774673"))
        returnList.add(Contact("Jennifer", "8034774677"))
        returnList.add(Contact("Porkchop", "230973455"))
        returnList.add(Contact("Jerry", "2598235547"))
        returnList.add(Contact("Joel","3939393939"))

        return returnList

    }

}


