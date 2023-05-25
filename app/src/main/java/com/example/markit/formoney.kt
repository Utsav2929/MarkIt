package com.example.markit

import android.content.Context
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.markit.databinding.ActivityFormoneyBinding
import com.example.markit.databinding.ActivityMarkattendenceBinding
import com.example.markit.databinding.ActivityPaymoneyBinding
import com.example.markit.databinding.ActivityRegisteremployeeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.*
import java.util.*


class formoney : AppCompatActivity() {
    private lateinit var binding: ActivityFormoneyBinding

    private lateinit var database: DatabaseReference

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        binding.

        binding.submitbutton.setOnClickListener {

            val cname = binding.cnameentry.text.toString()


            database = FirebaseDatabase.getInstance().getReference(cname+"salary")
            database.get().addOnSuccessListener {

                if (it.exists()) {
                    val Intent = Intent(this, moneydetails::class.java)
                        .putExtra("username", cname)
                    startActivity(Intent)

                } else {
                    Toast.makeText(this, "Incorrect companyid", Toast.LENGTH_SHORT).show()
                }


            }


        }


    }
}


