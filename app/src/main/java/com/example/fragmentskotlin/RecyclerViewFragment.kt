package com.example.fragmentskotlin

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.list_row_items.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RecyclerViewFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class RecyclerViewFragment : Fragment(), View.OnClickListener{
    private var listener: OnFragmentInteractionListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    // For communication between fragments
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(string :String)


    }

    override fun onClick(v: View?) {

            listener?.onFragmentInteraction(txtName.text.toString())
        Log.v("FRAG",txtName.text.toString())

    }


}
