package com.example.markit


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.markit.databinding.ActivityHomeBinding
//import com.example.markit.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var companyname = ""
    var username=""
        auth = FirebaseAuth.getInstance()
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

        val filename = "companyname.txt"
        if (filename.toString() != null) {
            var fileInputStream: FileInputStream? = null
            fileInputStream = openFileInput(filename)
            var inputStreamReader = InputStreamReader(fileInputStream)
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
//        binding.currentname.text=username
        val a = Intent(this, MainActivity3::class.java)
            .putExtra("companyname", companyname)
            .putExtra("username", username)
        startActivity(a)
    }
}
