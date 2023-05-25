package com.example.markit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.markit.databinding.ActivityRegistercompanyBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.*


class Registercompany : AppCompatActivity() {
    private lateinit var binding : ActivityRegistercompanyBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistercompanyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val auth = FirebaseAuth.getInstance()
        binding.submitbutton.setOnClickListener {
            val companyname = binding.companyentry.text.toString()
            val email = binding.emailentry.text.toString()
            val name = binding.nameentry.text.toString()
            val mobile= binding.mobileentry.text.toString()
            val passw1 = binding.Password.text.toString()
            val passw2=binding.Passwordconfrm.text.toString()
            val type= "owner"
            if(passw1!=passw2)
            {
                Toast.makeText(applicationContext, "Password doesn't match, try again...", Toast.LENGTH_SHORT).show()
            }
            else {
                database = FirebaseDatabase.getInstance().getReference("User")
                val user = user(companyname,name,email, mobile,type)
                auth.createUserWithEmailAndPassword(email, passw1).addOnCompleteListener{
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
                    }
                }
                val file:String ="companyname.txt"
                val data:String = companyname
                val fileOutputStream: FileOutputStream
                try {
                    fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                    fileOutputStream.write(data.toByteArray())
                } catch (e: FileNotFoundException){
                    e.printStackTrace()
                }catch (e: NumberFormatException){
                    e.printStackTrace()
                }catch (e: IOException){
                    e.printStackTrace()
                }catch (e: Exception){
                    e.printStackTrace()
                }

                val file1:String ="username.txt"
                val data1:String = name
                val fileOutputStream1: FileOutputStream
                try {
                    fileOutputStream1 = openFileOutput(file1, Context.MODE_PRIVATE)
                    fileOutputStream1.write(data1.toByteArray())
                } catch (e: FileNotFoundException){
                    e.printStackTrace()
                }catch (e: NumberFormatException){
                    e.printStackTrace()
                }catch (e: IOException){
                    e.printStackTrace()
                }catch (e: Exception){
                    e.printStackTrace()
                }

                database.child(companyname).setValue(user).addOnSuccessListener {
                    Toast.makeText(applicationContext, "Submitted successfully", Toast.LENGTH_SHORT).show()
                    val a = Intent(this, Login::class.java)
                        .putExtra("username",name)
                        .putExtra("email",email)

                    startActivity(a)


                }



            }

        }
        val login:Button = findViewById(R.id.account)
        login.setOnClickListener()
        {
            val Intent = Intent(this, Login::class.java)
            startActivity(Intent)
        }

    }
}
