package com.example.markit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.markit.databinding.ActivityAttendencedetailsBinding
//import com.example.btn27.databinding.ActivityCountributorBinding
//import com.example.btn27.databinding.ActivityUserlistBinding
import com.example.markit.databinding.ActivityShowemployeeBinding
import com.google.firebase.database.*

class attendencedetails : AppCompatActivity() {

    private lateinit var binding: ActivityAttendencedetailsBinding
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<date>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityAttendencedetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRecyclerview = findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)
        userArrayList = arrayListOf<date>()
        getUserData()

    }

    private fun getUserData() {


        var username =intent.getStringExtra("username").toString()
        dbref = FirebaseDatabase.getInstance().getReference(username.toString())

        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){


                        val user = userSnapshot.getValue(date::class.java)
                        userArrayList.add(user!!)

                    }

                    userRecyclerview.adapter = attendencedetailsadapter(userArrayList)


                }

            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
}