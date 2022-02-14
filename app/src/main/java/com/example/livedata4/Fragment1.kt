
package com.example.livedata4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class Fragment1 : Fragment() {

     private lateinit var database: DatabaseReference
      var nummer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


            database = Firebase.database.reference

            nummer++
             var nummerToString = nummer.toString()

            database.child("Fragment1").child(nummerToString).setValue("oncreate")


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        database = Firebase.database.reference
        nummer++
        var nummerToString = nummer.toString()
        database.child("Fragment_1").setValue("Created")
        database.child("Fragment1").child(nummerToString).setValue("oncreateView")


        return inflater.inflate(R.layout.fragment_1, container, false)




    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {

                    nummer++
                    var nummerToString = nummer.toString()

                    database.child("Fragment1").child(nummerToString).setValue("Companion objecct")



                }
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nummer++
        var nummerToString = nummer.toString()


        database.child("name").child("alex").setValue("alex")


        database.child("name").child("alex").get().addOnSuccessListener {


            view.findViewById<TextView>(R.id.txt_i_fragment1).text = it.getValue<String>()
            
        }

        database.child("Fragment1").child(nummerToString).setValue("onViewCreated")


        view.findViewById<Button>(R.id.Btn_goTo2_i_fragment_1).setOnClickListener {

            view.findNavController()
                .navigate(R.id.action_fragment1_to_fragment2)

        }


    }



    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment1").child(nummerToString).setValue("onViewStateRestored")


    }

    override fun onStart() {
        super.onStart()

        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment1").child(nummerToString).setValue("onStart")



    }

    override fun onResume() {
        super.onResume()

        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment1").child(nummerToString).setValue("onResum")


    }

    override fun onPause() {
        super.onPause()

        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment1").child(nummerToString).setValue("onPause")


    }

    override fun onStop() {
        super.onStop()

        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment1").child(nummerToString).setValue("onStop")


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

       nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment1").child(nummerToString).setValue("onSaveInstanceState")


    }


    override fun onDestroyView() {
        super.onDestroyView()

        nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment1").child(nummerToString).setValue("onDestroyView")
        database.child("Fragment_1").setValue("Destroyed")

    }
    override fun onDestroy() {
        super.onDestroy()

       nummer++
        var nummerToString = nummer.toString()

        database.child("Fragment1").child(nummerToString).setValue("onDestroy")


    }







}