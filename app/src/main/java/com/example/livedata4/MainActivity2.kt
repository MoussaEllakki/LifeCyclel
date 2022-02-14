package com.example.livedata4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {


    private lateinit var database: DatabaseReference

    var nummer = 0

    var txt2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        database = Firebase.database.reference

        nummer++
        var nummerToString = nummer.toString()









        database.child("Activity2").child(nummerToString).setValue("oncreate")

        database.child("Activity2").child("mainActivity2").setValue("Created")

        findViewById<Button>(R.id.btn_back).setOnClickListener {


            finish()

        }

    }


    override fun onStart() {
        super.onStart()

        nummer++
        var nummerToString = nummer.toString()
        database.child("Activity2").child(nummerToString).setValue("onStart")

    }


    override fun onResume() {
        super.onResume()

        nummer++
        var nummerToString = nummer.toString()
        database.child("Activity2").child(nummerToString).setValue("onResume")
    }

    override fun onStop() {
        super.onStop()
        nummer++
        var nummerToString = nummer.toString()

        database.child("Activity2").child(nummerToString).setValue("onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        nummer++
        var nummerToString = nummer.toString()
        database.child("Activity2").child("mainActivity2").setValue("Destroyed")
        database.child("Activity2").child(nummerToString).setValue("onDestroy")
    }


}