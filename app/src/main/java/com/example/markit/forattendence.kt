package com.example.markit

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.markit.databinding.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.*


class forattendence : AppCompatActivity() {
    private lateinit var binding : ActivityForattendenceBinding

    private lateinit var database: DatabaseReference
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForattendenceBinding.inflate(layoutInflater)
        setContentView(binding.root)




//        binding.


            binding.submitbutton.setOnClickListener {

                val cname = binding.cnameentry.text.toString()


                database = FirebaseDatabase.getInstance().getReference(cname)
                database.get().addOnSuccessListener {

                    if (it.exists()) {
                        val Intent = Intent(this, attendencedetails::class.java)
                            .putExtra("username", cname)
                        startActivity(Intent)

                    } else {
                        Toast.makeText(this, "Incorrect companyid", Toast.LENGTH_SHORT).show()
                    }


                }


            }





    }


}


