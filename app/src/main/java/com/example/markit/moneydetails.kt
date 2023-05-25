package com.example.markit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.markit.databinding.ActivityMoneydetailsBinding
import com.example.markit.databinding.ActivityRatinglistBinding
import com.google.firebase.database.*
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class moneydetails : AppCompatActivity() {

    private lateinit var binding: ActivityMoneydetailsBinding
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<money>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoneydetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRecyclerview = findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<money>()
        getUserData()



        Toast.makeText(this,"Successfuly ok Updated", Toast.LENGTH_SHORT).show()

    }

    private fun getUserData() {

        var username =intent.getStringExtra("username").toString()
//        username+="salary"
        dbref = FirebaseDatabase.getInstance().getReference(username+"salary")

        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){


                        val user = userSnapshot.getValue(money::class.java)
                        userArrayList.add(user!!)

                    }

                    userRecyclerview.adapter = moneydetailsadapter(userArrayList)


                }

            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
}