package com.example.livedata4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var txt_textview: TextView

    var nummer = 0

    private lateinit var database: DatabaseReference


    var txt = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Firebase.database.reference



        nummer++
        var nummerToString = nummer.toString()

        database.child("Activity1").child(nummerToString).setValue("oncreate")
        database.child("Activity1").child("mainActivity1").setValue("Created")



        findViewById<Button>(R.id.go_to_f1).setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(R.id.min_container1, Fragment1()).addToBackStack(null).commit()
        }

        findViewById<Button>(R.id.go_to_f2).setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(R.id.min_container1, Fragment2()).addToBackStack(null).commit()
        }





        findViewById<Button>(R.id.go_to_f3).setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(R.id.min_container1, Fragment3()).addToBackStack(null).commit()
        }


        findViewById<Button>(R.id.go_to_activity2).setOnClickListener {
            var goToActivity22: Intent = Intent(this, MainActivity2::class.java)
            startActivity(goToActivity22)

        }


    }


    override fun onStart() {
        super.onStart()
        nummer++
        var nummerToString = nummer.toString()
        database.child("Activity1").child(nummerToString).setValue("onStart")

    }

    override fun onResume() {
        super.onResume()

        nummer++
        var nummerToString = nummer.toString()
        database.child("Activity1").child(nummerToString).setValue("onResume")
    }

    override fun onStop() {
        super.onStop()

        nummer++
        var nummerToString = nummer.toString()
        database.child("Activity1").child(nummerToString).setValue("onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        nummer++
        var nummerToString = nummer.toString()
        database.child("Activity1").child("mainActivity1").setValue("Destroyed")
        database.child("Activity1").child(nummerToString).setValue("onDestroy")
    }


}