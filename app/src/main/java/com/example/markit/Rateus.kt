package com.example.markit

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.markit.databinding.ActivityRateusBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Rateus : AppCompatActivity() {
    private lateinit var binding : ActivityRateusBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRateusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitbutton.setOnClickListener {
            val name = intent.getStringExtra("username")
            val rate= binding.rank.text.toString()
            val suggestions=binding.suggestions.text.toString()



            database = FirebaseDatabase.getInstance().getReference("Rating")
            val rating = rating(name,rate, suggestions )

            database.child(name.toString()).setValue(rating).addOnSuccessListener {
                Toast.makeText(applicationContext, "Submitted successfully", Toast.LENGTH_SHORT).show()
                val Intent = Intent(this, home::class.java)


                startActivity(Intent)

            }





        }


    }


}
