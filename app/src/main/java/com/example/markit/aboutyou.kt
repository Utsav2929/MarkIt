package com.example.markit

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.markit.databinding.ActivityAboutyouBinding
import com.example.markit.databinding.ActivityMarkattendenceBinding
import com.example.markit.databinding.ActivityPaymoneyBinding
import com.example.markit.databinding.ActivityRegisteremployeeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.*


class aboutyou : AppCompatActivity() {
    private lateinit var binding : ActivityAboutyouBinding
    private lateinit var database : DatabaseReference

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutyouBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var username=""
        var companyname=""


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


        val filename1 ="username.txt"
        if(filename1.toString()!=null ) {
            var fileInputStream: FileInputStream? = null
            fileInputStream = openFileInput(filename1)
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




        database = FirebaseDatabase.getInstance().getReference(companyname.toString())
            database.child(username.toString()).get().addOnSuccessListener {

                if (it.exists()){
                    var name = it.child("name").value.toString()
                    var email = it.child("email").value.toString()
                    var mobile = it.child("mobile").value.toString()

                    var count = it.child("count").value.toString()
                    var total = it.child("total").value.toString()
                    var money = it.child("money").value.toString()
                    var type = it.child("type").value.toString().toString()

                    var late = it.child("late").value.toString().toString()
                    var working = it.child("working").value.toString().toString()

        binding.tvfirstName.text=name
        binding.emailid.text=email
                    binding.mobile.text=mobile
                    binding.count.text=count.toString()
                    binding.total.text=total.toString()

                    binding.money.text=money.toString()

                    binding.working.text=working.toString()


                    binding.late.text=late.toString()


                }else{

                    Toast.makeText(this,"User Doesn't Exist",Toast.LENGTH_SHORT).show()


                }

            }.addOnFailureListener{

                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


            }

        }
//            database.child(cname).setValue(attendence).addOnSuccessListener {
//                Toast.makeText(applicationContext, "Submitted successfully", Toast.LENGTH_SHORT).show()
//                val a = Intent(this, home::class.java)
//                startActivity(a)
//
//
//            }





    }





