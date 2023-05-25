package com.example.markit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.markit.databinding.ActivityMoneydetailsBinding
import com.example.markit.databinding.ActivityNotificationBinding
import com.example.markit.databinding.ActivityRatinglistBinding
import com.google.firebase.database.*
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class notification : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationBinding
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<notificationadd>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRecyclerview = findViewById(R.id.usernot)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<notificationadd>()
        getUserData()



        Toast.makeText(this,"Successfuly ok Updated", Toast.LENGTH_SHORT).show()

    }

    private fun getUserData() {

        var username =intent.getStringExtra("username").toString()
        dbref = FirebaseDatabase.getInstance().getReference(username+"notification")

        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){


                        val user = userSnapshot.getValue(notificationadd::class.java)
                        userArrayList.add(user!!)

                    }

                    userRecyclerview.adapter = notificationadapter(userArrayList)


                }

            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
}