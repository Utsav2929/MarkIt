package com.example.markit

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.markit.databinding.ActivityAdminloginBinding
import com.google.firebase.database.DatabaseReference

import com.google.firebase.auth.FirebaseAuth


class adminlogin : AppCompatActivity() {
    private lateinit var binding: ActivityAdminloginBinding
    private lateinit var database : DatabaseReference
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminloginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.loginbtn.setOnClickListener {
            val username =intent.getStringExtra("username")


            binding.logintext.text=username
            val email = binding.email.text.toString()
            val pass = binding.password.text.toString()

            if(email.isBlank() || pass.isBlank())
            {
                Toast.makeText(this, "Enter all feilds", Toast.LENGTH_SHORT).show()

            }

            if (email=="utsav@gmail.com" && pass=="123456") {
                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                val Intent = Intent(this, admin::class.java)

                startActivity(Intent)

            } else {
                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
            }


        }

    }

}
