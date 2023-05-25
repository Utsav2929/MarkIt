package com.example.markit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class admin : AppCompatActivity() {

    private  lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        auth = FirebaseAuth.getInstance()



        val login : Button = findViewById<Button>(R.id.userli)
        login.setOnClickListener()
        {
            val Intent= Intent(this, userslistadmin::class.java)
            startActivity(Intent)
        }

        val registerN : Button = findViewById<Button>(R.id.userratings)
        registerN.setOnClickListener()
        {
            val Intent= Intent(this, ratinglist::class.java)
            startActivity(Intent)
        }
    }
}