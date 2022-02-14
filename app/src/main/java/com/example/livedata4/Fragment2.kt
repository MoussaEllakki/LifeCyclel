package com.example.livedata4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class Fragment2 : Fragment() {

    private lateinit var database: DatabaseReference
    var nummer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            database = Firebase.database.reference
            nummer++

            var nummerToString = nummer.toString()
            database.child("Fragment2").child(nummerToString).setValue("oncreate")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        database = Firebase.database.reference
        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment2").child(nummerToString).setValue("oncreateView")
        database.child("Fragment_2").setValue("Created")
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            Fragment2().apply {
                arguments = Bundle().apply {

                    nummer++
                    var nummerToString = nummer.toString()

                    database.child("Fragment2").child(nummerToString).setValue("Companion objecct")
                }
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nummer++
        var nummerToString = nummer.toString()
        database.child("Fragment2").child(nummerToString).setValue("onViewCreated")
        view.findViewById<Button>(R.id.btn_go_to3_i_fragment2).setOnClickListener {

            view.findNavController()
                .navigate(R.id.action_fragment2_to_fragment3)
        }
    }


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment2").child(nummerToString).setValue("onViewStateRestored")
    }

    override fun onStart() {
        super.onStart()

        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment2").child(nummerToString).setValue("onStart")

    }

    override fun onResume() {
        super.onResume()

        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment2").child(nummerToString).setValue("onResum")
    }

    override fun onPause() {
        super.onPause()

        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment2").child(nummerToString).setValue("onPause")

    }

    override fun onStop() {
        super.onStop()

        nummer++
        var nummerToString = nummer.toString()
        database.child("Fragment2").child(nummerToString).setValue("onStop")


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        nummer++
        var nummerToString = nummer.toString()
        database.child("Fragment2").child(nummerToString).setValue("onSaveInstanceState")
    }


    override fun onDestroyView() {
        super.onDestroyView()

        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment2").child(nummerToString).setValue("onDestroyView")
        database.child("Fragment_2").setValue("Destroyed")

    }

    override fun onDestroy() {
        super.onDestroy()

        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment2").child(nummerToString).setValue("onDestroy")
    }


}