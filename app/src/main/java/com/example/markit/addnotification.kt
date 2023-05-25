package com.example.markit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.markit.databinding.ActivityAddnotificationBinding
import com.example.markit.databinding.ActivityNotificationBinding
import com.example.markit.databinding.ActivityRegisteremployeeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader


class addnotification : AppCompatActivity() {
    private lateinit var binding : ActivityAddnotificationBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddnotificationBinding.inflate(layoutInflater)
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
            val date = binding.date1.text.toString()
            val notification = binding.notificationadd.text.toString()




            database = FirebaseDatabase.getInstance().getReference(companyname + "notification")
            val notification1 = notificationadd(date.toString(), notification.toString())

            database.child(date).setValue(notification1).addOnSuccessListener {
                Toast.makeText(applicationContext, "Submitted successfully", Toast.LENGTH_SHORT)
                    .show()
                val a = Intent(this, home::class.java)
                startActivity(a)


            }

        }



            binding.submitbutton2.setOnClickListener {
                val date = binding.date1.text.toString()
                val notification = binding.notificationadd.text.toString()

if (date.isBlank())
{

    Toast.makeText(applicationContext, "Enter Date", Toast.LENGTH_SHORT).show()

}else {


    database = FirebaseDatabase.getInstance().getReference(companyname + "notification")
//                val notification1 = notificationadd(date.toString(),notification.toString())

    database.child(date).removeValue().addOnSuccessListener {
        Toast.makeText(applicationContext, "Deleted successfully", Toast.LENGTH_SHORT).show()
        val a = Intent(this, home::class.java)
        startActivity(a)


    }
}}






    }


}

