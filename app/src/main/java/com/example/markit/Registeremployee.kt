package com.example.markit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.markit.databinding.ActivityRegisteremployeeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader


class Registeremployee : AppCompatActivity() {
    private lateinit var binding : ActivityRegisteremployeeBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisteremployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var username=""
        var companyname=""

        val auth = FirebaseAuth.getInstance()
        val filename ="companyname.txt"
        if(filename.toString()!=null ) {
            var fileInputStream: FileInputStream? = null
            fileInputStream = openFileInput(filename)
            var inputStreamReader  = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
            }
            //Displaying data on EditText
            companyname = stringBuilder.toString()

//                 binding.currentname.text = username.toString()

        }

        val fileusername ="username.txt"
        if(fileusername.toString()!=null ) {
            var fileInputStream: FileInputStream? = null
            fileInputStream = openFileInput(fileusername)
            var inputStreamReader  = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
            }
            //Displaying data on EditText
            username = stringBuilder.toString()

//                 binding.currentname.text = username.toString()

        }
//        binding.

        binding.submitbutton.setOnClickListener {
            val email = binding.emailentry.text.toString()
            val name = binding.nameentry.text.toString()
            val cname = binding.cnameentry.text.toString()
            val mobile= binding.mobileentry.text.toString()
            val count = binding.needsentry.text.toString()
            val money=binding.moneyentry.text.toString()
            val working=binding.working.text.toString()
            val passw1=binding.password.text.toString()
             val total=0
            val type="employee"



            database = FirebaseDatabase.getInstance().getReference(companyname)
            val employee = employee(cname,name,email, mobile, count,money,total.toString(),type,working)
            auth.createUserWithEmailAndPassword(email, passw1).addOnCompleteListener{
                if (it.isSuccessful) {
                    Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
                }
            }
            database.child(cname).setValue(employee).addOnSuccessListener {
                Toast.makeText(applicationContext, "Submitted successfully", Toast.LENGTH_SHORT).show()
                val a = Intent(this, home::class.java)
                startActivity(a)


            }



        }

    }


}

