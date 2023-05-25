package com.example.markit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.markit.databinding.ActivityEmployeeloginBinding
import com.example.markit.databinding.ActivityLoginBinding
import com.google.firebase.database.DatabaseReference

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException


class employeelogin : AppCompatActivity() {
    private lateinit var binding: ActivityEmployeeloginBinding
    private lateinit var database: DatabaseReference
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeeloginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.loginbtn.setOnClickListener {


            val email = binding.email.text.toString()

            val username = binding.username.text.toString()
            val companyname = binding.companyidname.text.toString()
            val pass = binding.password.text.toString()


            database = FirebaseDatabase.getInstance().getReference("User")
            database.child(companyname).get().addOnSuccessListener {

                if (it.exists()) {
                    database = FirebaseDatabase.getInstance().getReference(companyname)
                    database.child(username).get().addOnSuccessListener {
                        if (it.exists()) {
                            val file: String = "companyname.txt"
                            val data: String = companyname
                            val fileOutputStream: FileOutputStream
                            try {
                                fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                                fileOutputStream.write(data.toByteArray())
                            } catch (e: FileNotFoundException) {
                                e.printStackTrace()
                            } catch (e: NumberFormatException) {
                                e.printStackTrace()
                            } catch (e: IOException) {
                                e.printStackTrace()
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                            val file1: String = "username.txt"
                            val data1: String = username
                            val fileOutputStream1: FileOutputStream
                            try {
                                fileOutputStream1 = openFileOutput(file1, Context.MODE_PRIVATE)
                                fileOutputStream1.write(data1.toByteArray())
                            } catch (e: FileNotFoundException) {
                                e.printStackTrace()
                            } catch (e: NumberFormatException) {
                                e.printStackTrace()
                            } catch (e: IOException) {
                                e.printStackTrace()
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                            auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                                if (it.isSuccessful) {
                                    Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT)
                                        .show()
                                    val Intent = Intent(this, home::class.java)

                                    startActivity(Intent)

                                } else {
                                    Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }


                } else {
                    Toast.makeText(this, "Incorrect Credentials", Toast.LENGTH_SHORT).show()
                }

            }

        }

    }
}
