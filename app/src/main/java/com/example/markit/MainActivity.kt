package com.example.markit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.markit.Login
import com.example.markit.R
import com.example.markit.Registercompany
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private  lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        val currentuser = auth.currentUser
        if(currentuser != null) {
            startActivity(Intent(this,home::class.java))
            finish()
        }

        val login : Button = findViewById<Button>(R.id.login)
        login.setOnClickListener()
        {
            val Intent= Intent(this, Login::class.java)
            startActivity(Intent)
        }
        val elogin : Button = findViewById<Button>(R.id.elogin)
        elogin.setOnClickListener()
        {
            val Intent= Intent(this, employeelogin::class.java)
            startActivity(Intent)
        }
        val registerC : Button = findViewById<Button>(R.id.registerC)
        registerC.setOnClickListener()
        {
            val Intent= Intent(this, Registercompany::class.java)
            startActivity(Intent)
        }
//        val registerN : Button = findViewById<Button>(R.id.registerN)
//        registerN.setOnClickListener()
//        {
//            val Intent= Intent(this, Registern::class.java)
//            startActivity(Intent)
//        }
    }
}